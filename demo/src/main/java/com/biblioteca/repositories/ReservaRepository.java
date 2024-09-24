package com.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.domains.Livro;
import com.biblioteca.domains.Reserva;
import com.biblioteca.domains.Usuario;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
 
    Optional<Reserva> findByLivro(Livro obj);
    Optional<Reserva> findByUsuario(Usuario user);
}
