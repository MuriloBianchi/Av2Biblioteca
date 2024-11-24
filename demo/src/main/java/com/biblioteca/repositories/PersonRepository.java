package com.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.domains.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByCpf(String cpf);
    Optional<Person> findByEmail(String email);
}
