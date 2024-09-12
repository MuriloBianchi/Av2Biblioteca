package com.biblioteca.domains;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.biblioteca.domains.dtos.ReservaDTO;
import com.biblioteca.domains.enums.StatusReserva;
import com.biblioteca.repositories.ReservaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtaReserva;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtaDevolucao;

    private String prazo;

    private double valor;

    private StatusReserva statusReserva;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idlivro")
    private Livro livro;

    public Reserva(){

    }

    public Reserva(long id, LocalDate dtaReserva, LocalDate dtaDevolucao, String prazo, double valor, Usuario usuario,
            Livro livro, StatusReserva statusReserva) {
        this.id = id;
        this.dtaReserva = dtaReserva;
        this.dtaDevolucao = dtaDevolucao;
        this.prazo = prazo;
        this.valor = valor;
        this.usuario = usuario;
        this.livro = livro;
        this.statusReserva = statusReserva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDtaReserva() {
        return dtaReserva;
    }

    public void setDtaReserva(LocalDate dtaReserva) {
        this.dtaReserva = dtaReserva;
    }

    public LocalDate getDtaDevolucao() {
        return dtaDevolucao;
    }

    public void setDtaDevolucao(LocalDate dtaDevolucao) {
        this.dtaDevolucao = dtaDevolucao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Reserva other = (Reserva) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public void ConfirmarReserva(){

    }

    public void CancelarReserva(){

    }

    public double CalcularMulta(){
        return 0;
    }

    public void FinalizarReserva(){

    }
}
