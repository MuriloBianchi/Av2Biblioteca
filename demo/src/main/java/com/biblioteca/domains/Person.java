package com.biblioteca.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.biblioteca.domains.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //declara Person como entidade para o Spring
@Table(name = "person") //name a tabela no BD
public abstract class Person {

    @Id //define com chave da entidade
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected String firstName;
    protected int idade;
    protected String telefone;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String password;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();
 
    protected int tipoUsuario;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    protected Set<Integer> personType = new HashSet<>();
    
    public Person() {
        super();
        addPersonType(TipoUsuario.ALUNO);
    }

    public Person(Long id, String firstName, String cpf, String email, String password, int idade, String telefone) {
        this.id = id;
        this.firstName = firstName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.idade = idade;
        this.telefone = telefone;
        addPersonType(TipoUsuario.ALUNO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario personType) {
        this.tipoUsuario = personType.getId();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addPersonType(TipoUsuario e){
        this.tipoUsuario = e.getId();
        this.personType.add(e.getId());
    }

    public Set<TipoUsuario> getPersonType() {
        return personType.stream().map(x -> TipoUsuario.toEnum(x)).collect(Collectors.toSet());
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

}
