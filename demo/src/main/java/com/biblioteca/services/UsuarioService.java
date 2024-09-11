package com.biblioteca.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.dtos.UsuarioDTO;
import com.biblioteca.repositories.UsuarioRepository;
import com.biblioteca.services.exceptions.DataIntegrityViolationException;
import com.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usersRepo;

        public List<UsuarioDTO> findAll() {
        return usersRepo.findAll().stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
    }

    public Usuario findById(long id) {
        Optional<Usuario> obj = usersRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! ID: " + id));
    }

    public Usuario findByCpf(String cpf) {
        Optional<Usuario> obj = usersRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! CPF: " + cpf));
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> obj = usersRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! E-mail: " + email));
    }

    public Usuario create(UsuarioDTO objDto) {
        objDto.setId(null);
        validaPorCPFeEmail(objDto);
        Usuario newObj = new Usuario(objDto);
        return usersRepo.save(newObj);
    }

    public Usuario update(long id, UsuarioDTO objDto) {
        objDto.setId(id);
        Usuario oldObj = findById(id);
        validaPorCPFeEmail(objDto);
        oldObj = new Usuario(objDto);
        return usersRepo.save(oldObj);
    }

        public void delete(long id) {
        usersRepo.deleteById(id);
    }

    private void validaPorCPFeEmail(UsuarioDTO objDto) {
        Optional<Usuario> obj = usersRepo.findByCpf(objDto.getCpf());

        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Atenção! CPF já cadastrado no sistema!");
        }

        Optional<Usuario> obj2 = usersRepo.findByEmail(objDto.getEmail());

        if (obj2.isPresent() && obj2.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Este e-mail já está sendo usado!");
        }
    }
}
