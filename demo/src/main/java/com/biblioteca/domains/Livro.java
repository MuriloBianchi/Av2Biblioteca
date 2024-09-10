package com.biblioteca.domains;

import com.biblioteca.domains.enums.StatusLivro;

public class Livro {

   private Long Id;
   private String isbn;
   private String titulo;
   private String autor;
   private Integer fachaEtaria;
   private Integer numeroPagina;

  public Livro() {
  }

public Livro(Long id, String isbn, String titulo, String autor, Integer fachaEtaria, Integer numeroPagina) {
    Id = id;
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.fachaEtaria = fachaEtaria;
    this.numeroPagina = numeroPagina;
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

public Integer getFachaEtaria() {
    return fachaEtaria;
}

public void setFachaEtaria(Integer fachaEtaria) {
    this.fachaEtaria = fachaEtaria;
}

public Integer getNumeroPagina() {
    return numeroPagina;
}

public void setNumeroPagina(Integer numeroPagina) {
    this.numeroPagina = numeroPagina;
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
