package com.biblioteca.domains.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.biblioteca.domains.Bibliotecario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BibliotecarioDTO {

    protected Long id;

    @NotNull(message = "O campo Nome não pode ser nulo!")
    @NotBlank(message = "O campo NOme não pode ser vazio!")
    protected String nome;

    @NotNull(message = "O campo Email não pode ser nulo!")
    @NotBlank(message = "O campo Email não pode ser vazio!")
    protected String email;

    @NotNull(message = "O campo Telefone não pode ser nulo!")
    @NotBlank(message = "O campo Telefone não pode ser vazio!")
    protected String telefone;
    
    @NotNull(message = "O campo CPF não pode ser nulo!")
    @CPF
    protected String cpf;

    public BibliotecarioDTO() {};

    public BibliotecarioDTO(Bibliotecario bibliotecario){
        this.id = bibliotecario.getId();
        this.nome = bibliotecario.getNome();
        this.email = bibliotecario.getEmail();
        this.cpf = bibliotecario.getCpf();
        this.telefone = bibliotecario.getTelefone();
    }

    public long getId() {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
