package com.biblioteca.domains;

import com.biblioteca.domains.enums.StatusLivro;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Livro {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long Id;

   private String isbn;

   private String titulo;
       
   @Column(unique = true)
   private String autor;

   private Integer faixaEtaria;
   private Integer numeroPagina;

   private Integer StatusLivro;   
   private Integer CategoriaLivro; 

    @ManyToOne
    @JoinColumn(name = "idBibliotecario")
   private Bibliotecario bibliotecario;

  public Livro() {
  }

public Livro(Long id, String isbn, String titulo, String autor, Integer faixaEtaria, Integer numeroPagina,
        Integer statusLivro, Integer categoriaLivro, Bibliotecario bibliotecario) {
    Id = id;
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.faixaEtaria = faixaEtaria;
    this.numeroPagina = numeroPagina;
    StatusLivro = statusLivro;
    CategoriaLivro = categoriaLivro;
    this.bibliotecario = bibliotecario;
}

public Long getId() {
    return Id;
}

public void setId(Long id) {
    Id = id;
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

public Integer getStatusLivro() {
    return StatusLivro;
}

public void setStatusLivro(Integer statusLivro) {
    StatusLivro = statusLivro;
}

public Integer getCategoriaLivro() {
    return CategoriaLivro;
}

public void setCategoriaLivro(Integer categoriaLivro) {
    CategoriaLivro = categoriaLivro;
}

public Bibliotecario getBibliotecario() {
    return bibliotecario;
}

public void setBibliotecario(Bibliotecario bibliotecario) {
    this.bibliotecario = bibliotecario;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Id == null) ? 0 : Id.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Livro other = (Livro) obj;
    if (Id == null) {
        if (other.Id != null)
            return false;
    } else if (!Id.equals(other.Id))
        return false;
    return true;
}

public void AtualizaStatus(StatusLivro statusLivro){
 return ;
}

public void Reserva(){
    return ;
   }

}
