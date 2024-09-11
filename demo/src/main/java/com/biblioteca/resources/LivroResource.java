package com.biblioteca.resources;

import java.net.URI;
import java.util.List;

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

import com.biblioteca.domains.Livro;
import com.biblioteca.domains.dtos.LivroDTO;
import com.biblioteca.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Long id){
        Livro obj = this.livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping(value = "/titulo/{titulo}")
    public ResponseEntity<LivroDTO> findByTitulo(@PathVariable String titulo){
        Livro obj = this.livroService.findByTitulo(titulo);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @GetMapping(value = "/autor/{autor}")
    public ResponseEntity<List<LivroDTO>> findByAutor(@PathVariable String autor){
        return ResponseEntity.ok().body(livroService.findByAutor(autor));
    }

    @GetMapping(value = "/faixaEtaria/{faixaEtaria}")
    public ResponseEntity<List<LivroDTO>> findByAutor(@PathVariable Integer faixaEtaria){
        return ResponseEntity.ok().body(livroService.findByFaixaEtaria(faixaEtaria));
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO objDto) {
        Livro newObj = livroService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @Valid @RequestBody LivroDTO objDto) {
        Livro obj = livroService.update(id, objDto);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
