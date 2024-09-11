package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.domains.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
