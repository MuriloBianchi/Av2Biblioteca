package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.domains.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
