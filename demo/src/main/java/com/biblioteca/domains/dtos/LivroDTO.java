package com.biblioteca.domains.dtos;

import com.biblioteca.domains.Livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LivroDTO {

    protected Long id;

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
    protected Integer faixaEtaria;

    @NotNull(message = "O campo Número de Páginas não pode ser nulo!")
    @NotBlank(message = "O campo Número de Páginas não pode ser vazio!")
    protected Integer numeroPagina;

    @NotNull(message = "O campo Bibliotecario não pode ser nulo!")
    @NotBlank(message = "O campo Bibliotecario não pode ser vazio!")
    private Long bibliotecario;

    private String nomeBibliotecario;

    @NotNull(message = "O campo Status Livro não pode ser nulo!")
    @NotBlank(message = "O campo Status Livro não pode ser vazio!")
    private Integer statusLivro;

    @NotNull(message = "O campo Categoria não pode ser nulo!")
    @NotBlank(message = "O campo Categoria não pode ser vazio!")
    private Integer categoriaLivro;

    public LivroDTO() {};


    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.faixaEtaria = livro.getFaixaEtaria();
        this.numeroPagina = livro.getNumeroPagina();
        this.statusLivro = livro.getStatusLivro().getId();
        this.categoriaLivro = livro.getCategoriaLivro().getId();   
        this.bibliotecario = livro.getBibliotecario().getId();
        this.nomeBibliotecario = livro.getBibliotecario().getNome();
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Integer getFaixaEtaria() {
        return faixaEtaria;
    }


    public void setFaixaEtaria(Integer faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }


    public Integer getNumeroPagina() {
        return numeroPagina;
    }


    public void setNumeroPagina(Integer numeroPagina) {
        this.numeroPagina = numeroPagina;
    }


    public Long getBibliotecario() {
        return bibliotecario;
    }


    public void setBibliotecario(Long bibliotecario) {
        this.bibliotecario = bibliotecario;
    }


    public Integer getStatusLivro() {
        return statusLivro;
    }


    public void setStatusLivro(Integer statusLivro) {
        this.statusLivro = statusLivro;
    }


    public Integer getCategoriaLivro() {
        return categoriaLivro;
    }


    public void setCategoriaLivro(Integer categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }


    public String getNomeBibliotecario() {
        return nomeBibliotecario;
    }


    public void setNomeBibliotecario(String nomeBibliotecario) {
        this.nomeBibliotecario = nomeBibliotecario;
    }

    
}
