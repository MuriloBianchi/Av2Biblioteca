package com.biblioteca.domains.dtos;

import com.biblioteca.domains.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    protected long id;

    @NotNull(message = "O campo Nome não pode ser nulo!")
    @NotBlank(message = "O campo Nome não pode ser vazio!")
    protected String nome;

    @NotNull(message = "O campo E-mail não pode ser nulo!")
    @NotBlank(message = "O campo E-mail não pode ser vazio!")
    protected String email;

    @NotNull(message = "O campo CPF não pode ser nulo!")
    @NotBlank(message = "O campo CPF não pode ser vazio!")
    protected String cpf;

    @NotNull(message = "O campo Idade não pode ser nulo!")
    @NotBlank(message = "O campo Idade não pode ser vazio!")
    protected Integer idade;

    @NotNull(message = "O campo Telefone não pode ser nulo!")
    @NotBlank(message = "O campo Telefone não pode ser vazio!")
    protected String telefone;

    @NotNull(message = "O campo Tipo Usuário não pode ser nulo!")
    @NotBlank(message = "O campo Tipo Usuário não pode ser vazio!")
    protected Integer tipoUsuario;

    public UsuarioDTO() {};

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.idade = usuario.getIdade();
        this.telefone = usuario.getTelefone();
        this.tipoUsuario = usuario.getTipoUsuario().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
}
