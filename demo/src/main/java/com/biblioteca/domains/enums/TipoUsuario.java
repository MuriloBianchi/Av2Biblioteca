package com.biblioteca.domains.enums;

public enum TipoUsuario {

ALUNO(0,"ALUNO"), BIBLIOTECARIO(2,"BIBLIOTECARIO");

private Integer id;
private String tipoUsuario;

private TipoUsuario(Integer id, String tipoUsuario) {
    this.id = id;
    this.tipoUsuario = tipoUsuario;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTipoUsuario() {
    return tipoUsuario;
}

public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
}

public static TipoUsuario toEnum(Integer id) {
    if (id == null) {
        return null;
    }
    for(TipoUsuario x: TipoUsuario.values()) {
        if (id.equals(x.getId())) {
            return x;
        }
    }
    throw new IllegalArgumentException("Tipo Usuário inválido!");
}

}
