package com.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.domains.Livro;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTitulo(String titulo);
    Optional<Livro> findByAutor(String autor);
    Optional<Livro> findByFaixaEtaria(Integer faixaEtaria);
}
