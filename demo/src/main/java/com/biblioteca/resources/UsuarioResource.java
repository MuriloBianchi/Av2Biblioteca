package com.biblioteca.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.dtos.UsuarioDTO;
import com.biblioteca.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usersService;

     @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario obj = this.usersService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<UsuarioDTO> findByCpf(@PathVariable String cpf) {
        Usuario obj = this.usersService.findByCpf(cpf);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email) {
        Usuario obj = this.usersService.findByEmail(email);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objDto) {
        Usuario newObj = usersService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO objDto) {
        Usuario obj = usersService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
