package com.biblioteca.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.dtos.BibliotecarioDTO;
import com.biblioteca.services.BibliotecarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/bibliotecario")
public class BibliotecarioResource {
    
    @Autowired
    private BibliotecarioService bibliotecarioService;

public ResponseEntity<BibliotecarioDTO> findById(@PathVariable Long id){
    Bibliotecario obj = this.bibliotecarioService.findById(id);
    return ResponseEntity.ok().body(new BibliotecarioDTO(obj));
}

    public ResponseEntity<List<BibliotecarioDTO>> findAll(){
        return ResponseEntity.ok().body(bibliotecarioService.findAll());
    }

    public ResponseEntity<BibliotecarioDTO> create(@Valid @RequestBody BibliotecarioDTO objDto){
        Bibliotecario newObj = bibliotecarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<BibliotecarioDTO> update(@PathVariable Long id, @Valid @RequestBody BibliotecarioDTO obDto){
        Bibliotecario obj = bibliotecarioService.update(id, obDto);
        return ResponseEntity.ok().body(new BibliotecarioDTO(obj));
    }

}
