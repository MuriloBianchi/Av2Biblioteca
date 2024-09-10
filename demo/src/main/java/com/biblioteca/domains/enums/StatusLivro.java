package com.biblioteca.domains.enums;

public enum StatusLivro {
   DISPONIVEL(0,"DISPONIVEL"), EMPRESTADO(1,"EMPRESTADO"), RESERVADO(2,"RESERVADO"), INDISPONIVEL(3,"INDISPONIVEL");

   private Integer id;
   private String statusLivro;
   
private StatusLivro(Integer id, String statusLivro) {
    this.id = id;
    this.statusLivro = statusLivro;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getStatusLivro() {
    return statusLivro;
}

public void setStatusLivro(String statusLivro) {
    this.statusLivro = statusLivro;
}

public static StatusLivro toEnum(Integer id) {
    if (id == null) {
        return null;
    }
    for(StatusLivro x: StatusLivro.values()) {
        if (id.equals(x.getId())) {
            return x;
        }
    }
    throw new IllegalArgumentException("Status Livro inválida!");
}
   
}
