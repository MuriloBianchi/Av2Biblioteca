package com.biblioteca.services;

import java.util.Collection;
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
 private ReservaRepository ReservaRepo;

 @Autowired
 private LivroService livroService;

 @Autowired
 private UsuarioService usuarioService;


/* public ReservaService findbyId(Long id){
    Optional<ReservaService> obj = ReservaRepo.findbyId(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Reserva Não Encontrada! Id:"+id));
 } */

 public List<ReservaDTO> findAll(){
    return ReservaRepo.findAll().stream().map(obj -> new ReservaDTO(obj)).collect(Collectors.toList());
 }


 private Reserva newsReserva(ReservaDTO obj){
    Usuario usu = usuarioService.findById(obj.getUsuario());
    Livro liv = livroService.findById(obj.getLivro());

    Reserva re = new Reserva();
    
    /*if(obj.getId() != null){
        re.setId(obj.getId());
    } */

    re.setUsuario(usu);
    re.setLivro(liv);

    return re;

 }

  public Reserva create(ReservaDTO objDto){
    return ReservaRepo.save(newsReserva(objDto));
  }

  /*public Reserva update(Long id, ReservaDTO objDto){
    objDto.setId(id);
    Reserva oldObj = findById(id);
    oldObj = newsReserva(objDto);
    return ReservaRepo.save(oldObj);
  }*/

}
