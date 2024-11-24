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

import com.biblioteca.domains.Livro;
import com.biblioteca.domains.dtos.LivroDTO;
import com.biblioteca.repositories.ReservaRepository;
import com.biblioteca.services.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/livro")
@Tag(name = "Livro", description = "API para gerenciamento de Livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @Autowired
    private ReservaRepository reserRepo;

    @Operation(summary = "Lista todos os Livros", description = "Retorna uma lista com todos os livros.")
    @PreAuthorize("hasRole('BIBLIOTECARIO' or 'ALUNO')")
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @Operation(summary = "Buscar livro por ID", description = "Retorna um livro com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO' or 'ALUNO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Long id){
        Livro obj = this.livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @Operation(summary = "Buscar bibliotecario por Titulo", description = "Retorna um livro com base no titulo fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO' or 'ALUNO')")
    @GetMapping(value = "/titulo/{titulo}")
    public ResponseEntity<LivroDTO> findByTitulo(@PathVariable String titulo){
        Livro obj = this.livroService.findByTitulo(titulo);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @Operation(summary = "Lista livros por Autor", description = "Retorna uma lista com todos os livros de um autor.")
    @PreAuthorize("hasRole('BIBLIOTECARIO' or 'ALUNO')")
    @GetMapping(value = "/autor/{autor}")
    public ResponseEntity<List<LivroDTO>> findByAutor(@PathVariable String autor){
        return ResponseEntity.ok().body(livroService.findByAutor(autor));
    }

    @Operation(summary = "Lista livros por Faixa Etaria", description = "Retorna uma lista de livros com base na faixa etaria informada.")
    @PreAuthorize("hasRole('BIBLIOTECARIO' or 'ALUNO')")
    @GetMapping(value = "/faixaEtaria/{faixaEtaria}")
    public ResponseEntity<List<LivroDTO>> findByAutor(@PathVariable Integer faixaEtaria){
        return ResponseEntity.ok().body(livroService.findByFaixaEtaria(faixaEtaria));
    }

    @Operation(summary = "Cria um novo Livro", description = "Cria um novo livro com base nos dados fornecidos.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PostMapping
    public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO objDto) {
        Livro newObj = livroService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza um  livro", description = "Atualiza um livro com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @Valid @RequestBody LivroDTO objDto) {
        Livro obj = livroService.update(id, objDto);
        return ResponseEntity.ok().body(new LivroDTO(obj));
    }

    @Operation(summary = "Deleta um  livro", description = "Deleta um livro com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
       Livro obj = livroService.findById(id);

       if(reserRepo.findByLivro(obj).isPresent()){
        return ResponseEntity.ok().body("Livro possui reserva");
        };

        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
