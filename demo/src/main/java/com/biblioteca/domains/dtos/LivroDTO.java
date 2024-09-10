package com.biblioteca.domains.dtos;

import com.biblioteca.domains.Livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LivroDTO {

    protected long id;

    @NotNull(message = "O campo ISBN não pode ser nulo!")
    @NotBlank(message = "O campo ISBN não pode ser vazio!")
    protected String isbn;

    @NotNull(message = "O campo Titulo não pode ser nulo!")
    @NotBlank(message = "O campo Titulo não pode ser vazio!")
    protected String titulo;

    @NotNull(message = "O campo Autor não pode ser nulo!")
    @NotBlank(message = "O campo Autor não pode ser vazio!")
    protected String autor;

    @NotNull(message = "O campo Facha Etário não pode ser nulo!")
    @NotBlank(message = "O campo Facha Etária não pode ser vazio!")
    protected Integer fachaEtaria;

    @NotNull(message = "O campo Número de Páginas não pode ser nulo!")
    @NotBlank(message = "O campo Número de Páginas não pode ser vazio!")
    protected Integer numeroPagina;

    @NotNull(message = "O campo Bibliotecario não pode ser nulo!")
    @NotBlank(message = "O campo Bibliotecario não pode ser vazio!")
    private long bibliotecario;

    public LivroDTO() {};


    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.fachaEtaria = livro.getFachaEtaria();
        this.numeroPagina = livro.getNumeroPagina();
        
    }
}
