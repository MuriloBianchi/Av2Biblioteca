package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.domains.Bibliotecario;
@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

}
