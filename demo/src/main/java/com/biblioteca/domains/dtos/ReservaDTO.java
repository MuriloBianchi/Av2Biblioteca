package com.biblioteca.domains.dtos;
import java.time.LocalDate;

import com.biblioteca.domains.Reserva;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ReservaDTO {

    protected Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dtaReserva;

    @NotNull(message = "O campo Data de Devolução não pode ser nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dtaDevolucao;

    @NotNull(message = "O campo Prazo não pode ser nulo!")
    @NotBlank(message = "O campo Prazo não pode ser vazio!")
    protected String prazo;

    @NotNull(message = "O campo Valor não pode ser nulo!")
    protected double valor;

    @NotNull(message = "O campo Status Reserva não pode ser nulo!")
    protected Integer statusReserva;

    @NotNull(message = "O campo Usuário não pode ser nulo!")
    protected Long usuario;

    @NotNull(message = "O campo Livro não pode ser nulo!")
    protected Long livro;

    protected String nomeUsuario;

    protected String tituloLivro;

    public ReservaDTO() {};

    public ReservaDTO(Reserva reserva){
        this.id = reserva.getId();
        this.dtaReserva = reserva.getDtaReserva();
        this.dtaDevolucao = reserva.getDtaDevolucao();
        this.prazo = reserva.getPrazo();
        this.valor = reserva.getValor();
        this.statusReserva = reserva.getStatusReserva().getId();
        this.usuario = reserva.getUsuario().getId();
        this.livro = reserva.getLivro().getId();
        this.nomeUsuario = reserva.getUsuario().getFirstName();
        this.tituloLivro = reserva.getLivro().getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(Integer statusReserva) {
        this.statusReserva = statusReserva;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getLivro() {
        return livro;
    }

    public void setLivro(Long livro) {
        this.livro = livro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

}
