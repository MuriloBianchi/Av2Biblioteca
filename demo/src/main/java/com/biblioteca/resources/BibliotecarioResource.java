package com.biblioteca.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.dtos.BibliotecarioDTO;
import com.biblioteca.repositories.LivroRepository;
import com.biblioteca.services.BibliotecarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/bibliotecario")
@Tag(name = "Bibliotecario", description = "API para gerenciamento de bibliotecarios")
public class BibliotecarioResource {
    
    @Autowired
    private BibliotecarioService bibliotecarioService;

    @Autowired
    private LivroRepository livroRepo;

    @Operation(summary = "Buscar bibliotecario por ID", description = "Retorna um biblioteacario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BibliotecarioDTO> findById(@PathVariable Long id){
        Bibliotecario obj = this.bibliotecarioService.findById(id);
        return ResponseEntity.ok().body(new BibliotecarioDTO(obj));
    }

    @Operation(summary = "Lista todos os bibliotecario", description = "Retorna uma lista com todos os biblioteacarios.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping
    public ResponseEntity<List<BibliotecarioDTO>> findAll(){
        return ResponseEntity.ok().body(bibliotecarioService.findAll());
    }

    @Operation(summary = "Cria um novo bibliotecario", description = "Cria um novo biblioteacario com base nos dados fornecidos.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PostMapping
    public ResponseEntity<BibliotecarioDTO> create(@Valid @RequestBody BibliotecarioDTO objDto){
        Bibliotecario newObj = bibliotecarioService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza um  bibliotecario", description = "Atualiza um biblioteacario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BibliotecarioDTO> update(@PathVariable Long id, @Valid @RequestBody BibliotecarioDTO obDto){
        Bibliotecario obj = bibliotecarioService.update(id, obDto);
        return ResponseEntity.ok().body(new BibliotecarioDTO(obj));
    }

    @Operation(summary = "Deleta um  bibliotecario", description = "Deleta um bibliotecario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Bibliotecario bibli = bibliotecarioService.findById(id);

        if (livroRepo.findByBibliotecario(bibli).isPresent()) {
            return ResponseEntity.ok().body("Bibliotecario possui livros");
        }
        
        bibliotecarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
