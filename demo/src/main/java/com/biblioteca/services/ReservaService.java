package com.biblioteca.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Livro;
import com.biblioteca.domains.Reserva;
import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.dtos.ReservaDTO;
import com.biblioteca.repositories.ReservaRepository;
import com.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepo;

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    public Reserva findbyId(Long id){
        Optional<Reserva> obj = reservaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Reserva Não Encontrado! Id:"+id));
    }

    public List<ReservaDTO> findAll(){
        return reservaRepo.findAll().stream().map(obj -> new ReservaDTO(obj)).collect(Collectors.toList());
    }

    private Reserva newsReserva(ReservaDTO obj){
        Livro livr = livroService.findById(obj.getLivro());
        Usuario usur = usuarioService.findById(obj.getLivro());

        if (obj.getId() != null) {
            obj.setId(obj.getId());
        }
        
        Reserva newReserva = new Reserva(obj);
        
        newReserva.setLivro(livr);
        newReserva.setUsuario(usur);
        return newReserva;
    }

    public Reserva create(ReservaDTO objDto){
        return reservaRepo.save(newsReserva(objDto));
    }

    public Reserva update(Long id, ReservaDTO objDto){
        objDto.setId(id);
        Reserva oldObj = findbyId(id);
        oldObj = newsReserva(objDto);
        return reservaRepo.save(oldObj);
    }

    public void delete(Long id) {
        reservaRepo.deleteById(id);
    }

}
