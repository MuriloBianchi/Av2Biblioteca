package com.biblioteca.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.Livro;
import com.biblioteca.domains.Reserva;
import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.enums.CategoriaLivro;
import com.biblioteca.domains.enums.StatusLivro;
import com.biblioteca.domains.enums.StatusReserva;
import com.biblioteca.repositories.BibliotecarioRepository;
import com.biblioteca.repositories.LivroRepository;
import com.biblioteca.repositories.ReservaRepository;
import com.biblioteca.repositories.UsuarioRepository;

@Service
public class DBService {

    @Autowired
    private BibliotecarioRepository bibliRepo;

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private ReservaRepository reseRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){
        Bibliotecario bibli = new Bibliotecario(null, "Joao", "48761416819", "joao@gmail.com", encoder.encode("12345"), 30, "1799999999");

        Livro liv = new Livro(null, "TESTE", "LivroDoMichael", "Michael", 18, 200, StatusLivro.DISPONIVEL, CategoriaLivro.ROMANCE, bibli);

        Usuario user = new Usuario(null, "Maria", "54672480062", "maria@gmail.com", encoder.encode("12345"), 16, "179999999" );

        Reserva rese = new Reserva(null, LocalDate.now(), LocalDate.now(), "1", 50, user, liv, StatusReserva.ATIVO);

        bibliRepo.save(bibli);
        livroRepo.save(liv);
        userRepo.save(user);
        reseRepo.save(rese);
    }
}
