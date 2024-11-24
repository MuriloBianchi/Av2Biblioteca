package com.biblioteca.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.dtos.BibliotecarioDTO;
import com.biblioteca.repositories.BibliotecarioRepository;
import com.biblioteca.services.exceptions.DataIntegrityViolationException;
import com.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class BibliotecarioService {
    
    @Autowired
    private BibliotecarioRepository bibliotecarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public List<BibliotecarioDTO> findAll(){
        return bibliotecarioRepo.findAll().stream().map(obj -> new BibliotecarioDTO(obj)).collect(Collectors.toList());
    } 

    public Bibliotecario findById(Long id){
        Optional<Bibliotecario> obj = bibliotecarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Bibliotecario não Encontrado! Id:"+id)); 
    }
 
    public Bibliotecario findByCpf(String cpf) {
        Optional<Bibliotecario> obj = bibliotecarioRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! CPF: " + cpf));
    }

    public Bibliotecario findByEmail(String email) {
        Optional<Bibliotecario> obj = bibliotecarioRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! E-mail: " + email));
    }

        public Bibliotecario create(BibliotecarioDTO objDto) {
        objDto.setId(null);
        objDto.setPassword(encoder.encode(objDto.getPassword()));
        validaPorCPFeEmail(objDto);
        Bibliotecario newObj = new Bibliotecario(objDto);
        return bibliotecarioRepo.save(newObj);
    }

    public Bibliotecario update(long id, BibliotecarioDTO objDto) {
        objDto.setId(id);
        Bibliotecario oldObj = findById(id);
        objDto.setPassword(encoder.encode(objDto.getPassword()));
        validaPorCPFeEmail(objDto);
        oldObj = new Bibliotecario(objDto);
        return bibliotecarioRepo.save(oldObj);
    }

        public void delete(long id) {
            bibliotecarioRepo.deleteById(id);
    }
   
    private void validaPorCPFeEmail(BibliotecarioDTO objDto) {
        Optional<Bibliotecario> obj = bibliotecarioRepo.findByCpf(objDto.getCpf());

        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Atenção! CPF já cadastrado no sistema!");
        }

        Optional<Bibliotecario> obj2 = bibliotecarioRepo.findByEmail(objDto.getEmail());

        if (obj2.isPresent() && obj2.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Este e-mail já está sendo usado!");
        }
    }

}
