package com.biblioteca.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.Livro;
import com.biblioteca.domains.Reserva;
import com.biblioteca.domains.Usuario;
import com.biblioteca.domains.enums.CategoriaLivro;
import com.biblioteca.domains.enums.StatusLivro;
import com.biblioteca.domains.enums.StatusReserva;
import com.biblioteca.domains.enums.TipoUsuario;
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

    public void initDB(){
        Bibliotecario bibli = new Bibliotecario(null, "Joao", "joao@gmail.com", "1798888890", "44505001806");

        Livro liv = new Livro(null, "TESTE", "LivroDoMichael", "Michael", 18, 200, StatusLivro.DISPONIVEL, CategoriaLivro.ROMANCE, bibli);

        Usuario user = new Usuario(null, "Maria", "maria@gmail.com", "48761416819", 17, "123456789", TipoUsuario.ALUNO);

        Reserva rese = new Reserva(null, LocalDate.now(), LocalDate.now(), "1", 50, user, liv, StatusReserva.ATIVO);

        bibliRepo.save(bibli);
        livroRepo.save(liv);
        userRepo.save(user);
        reseRepo.save(rese);
    }
}
