package com.biblioteca.domains.dtos;

import com.biblioteca.domains.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    protected Long id;

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
    protected Integer idade;

    @NotNull(message = "O campo Telefone não pode ser nulo!")
    @NotBlank(message = "O campo Telefone não pode ser vazio!")
    protected String telefone;

    protected Integer tipoUsuario;

    @NotNull(message = "O campo senha não pode ser nulo")
    @NotBlank(message = "O campo senha não pode ser vazio")
    protected String password;

    public UsuarioDTO() {};

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getFirstName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.cpf = usuario.getCpf();
        this.idade = usuario.getIdade();
        this.telefone = usuario.getTelefone();
        this.tipoUsuario = usuario.getTipoUsuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
