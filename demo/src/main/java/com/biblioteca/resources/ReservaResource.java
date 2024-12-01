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

import com.biblioteca.domains.Reserva;
import com.biblioteca.domains.dtos.ReservaDTO;
import com.biblioteca.services.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/reserva")
@Tag(name = "Reserva", description = "API para gerenciamento de Reservas")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    @Operation(summary = "Buscar Reserva por ID", description = "Retorna um Reserva com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')or hasRole('ALUNO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id){
        Reserva obj = this.reservaService.findbyId(id);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @Operation(summary = "Lista todos os Reserva", description = "Retorna uma lista com todos os biblioteacarios.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')or hasRole('ALUNO')")
    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll(){
        return ResponseEntity.ok().body(reservaService.findAll());
    }

    @Operation(summary = "Cria um novo Reserva", description = "Cria um novo Reserva com base nos dados fornecidos.")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ALUNO')")
    @PostMapping
    public ResponseEntity<ReservaDTO> create(@Valid @RequestBody ReservaDTO objDto){
        Reserva newObj = reservaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza um  Reserva", description = "Atualiza um Reserva com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ALUNO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO obDto){
        Reserva obj = reservaService.update(id, obDto);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @Operation(summary = "Deleta um  Reserva", description = "Deleta um Reserva com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
