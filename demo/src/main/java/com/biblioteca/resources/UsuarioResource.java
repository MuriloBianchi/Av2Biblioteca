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

import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.dtos.UsuarioDTO;
import com.biblioteca.repositories.ReservaRepository;
import com.biblioteca.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
@Tag(name = "Usuario", description = "API para gerenciamento de Usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usersService;

    @Autowired
    private ReservaRepository reservaRepo;

    @Operation(summary = "Lista todos os Usuarios", description = "Retorna uma lista com todos os Usuarios.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll());
    }

    @Operation(summary = "Buscar usuario por ID", description = "Retorna um usuario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario obj = this.usersService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Buscar usuario por cpf", description = "Retorna um usuario com base no cpf fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<UsuarioDTO> findByCpf(@PathVariable String cpf) {
        Usuario obj = this.usersService.findByCpf(cpf);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Buscar usuario pelo email", description = "Retorna um usuario com base no email fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email) {
        Usuario obj = this.usersService.findByEmail(email);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Cria um novo Usuario", description = "Cria um novo Usuario com base nos dados fornecidos.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objDto) {
        Usuario newObj = usersService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza um  Usuario", description = "Atualiza um Usuario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO objDto) {
        Usuario obj = usersService.update(id, objDto);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @Operation(summary = "Deleta um Usuario", description = "Deleta um usuario com base no ID fornecido.")
    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Usuario user = usersService.findById(id);

        if (reservaRepo.findByUsuario(user).isPresent()) {
            return ResponseEntity.ok().body("Usuario possui reserva");
        }

        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
