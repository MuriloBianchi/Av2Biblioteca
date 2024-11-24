package com.biblioteca.domains;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.domains.dtos.BibliotecarioDTO;
import com.biblioteca.domains.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Bibliotecario extends Person{
  
    @JsonIgnore
    @OneToMany(mappedBy = "bibliotecario")
    private List<Livro> livros = new ArrayList<>();
    
    public Bibliotecario(Long id, String firstName, String cpf, String email, String password, int idade, String telefone) {
        super(id, firstName, cpf, email, password, idade, telefone);
        addPersonType(TipoUsuario.ALUNO);
    }

    public Bibliotecario(BibliotecarioDTO obj){
        this.id = obj.getId();
        this.firstName = obj.getNome();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.idade = obj.getIdade();
        this.password = obj.getPassword();
        this.telefone = obj.getTelefone();
        this.tipoUsuario = TipoUsuario.BIBLIOTECARIO.getId();
    }

    public Bibliotecario(){
        super();
        addPersonType(TipoUsuario.ALUNO);
    }

    public List<Livro> getReservas() {
        return livros;
    }

    public void setReservas(List<Livro> reservas) {
        this.livros = reservas;
    }

 
    public void RemoveLivro(){
        return ;
       }
    
       public void CadastraLivro(){
        return ;
       }
}
