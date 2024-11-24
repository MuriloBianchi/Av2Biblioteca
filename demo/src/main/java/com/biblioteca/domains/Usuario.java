package com.biblioteca.domains;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.domains.dtos.UsuarioDTO;
import com.biblioteca.domains.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Usuario extends Person{

    @JsonIgnore
    @OneToMany(mappedBy = "usuario") // user é o nome do atributo em ServiceOrder
    private List<Reserva> reservas = new ArrayList<>();
    
    public Usuario(Long id, String firstName, String cpf, String email, String password, int idade, String telefone) {
        super(id, firstName, cpf, email, password, idade, telefone);
        addPersonType(TipoUsuario.ALUNO);
    }

    public Usuario(UsuarioDTO obj){
        this.id = obj.getId();
        this.firstName = obj.getNome();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.idade = obj.getIdade();
        this.password = obj.getPassword();
        this.telefone = obj.getTelefone();
        this.tipoUsuario = TipoUsuario.ALUNO.getId();
    }

    public Usuario(){
        super();
        addPersonType(TipoUsuario.ALUNO);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

     public void EmprestarLivro(Livro livro){
        
    } 

    public void DevolverLivro(Livro livro){

    }
}
