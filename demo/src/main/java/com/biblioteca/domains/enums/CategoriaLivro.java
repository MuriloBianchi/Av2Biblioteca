package com.biblioteca.domains.enums;

public enum CategoriaLivro {
   FICCAO(0, "FICÇÃO"), ROMANCE(1, "ROMANCE"), TERROR(2,"TERROR"), AVENTURA(3, "AVENTURA");

   private Integer id;
   private String categoriaLivro;

private CategoriaLivro(Integer id, String categoriaLivro) {
    this.id = id;
    this.categoriaLivro = categoriaLivro;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getCategoriaLivro() {
    return categoriaLivro;
}

public void setCategoriaLivro(String categoriaLivro) {
    this.categoriaLivro = categoriaLivro;
}

public static CategoriaLivro toEnum(Integer id) {
    if (id == null) {
        return null;
    }
    for(CategoriaLivro x: CategoriaLivro.values()) {
        if (id.equals(x.getId())) {
            return x;
        }
    }
    throw new IllegalArgumentException("Categoria Livro inválida!");
}
  
}
