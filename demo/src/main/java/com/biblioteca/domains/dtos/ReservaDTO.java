package com.biblioteca.domains.dtos;
import java.time.LocalDate;

import com.biblioteca.domains.Reserva;
import com.fasterxml.jackson.annotation.JsonFormat;


public class ReservaDTO {

    protected long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dtaReserva;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dtaDevolucao;

    protected String prazo;

    protected double valor;

    protected Integer statusReserva;

    protected long usuario;

    protected long livro;

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
        this.nomeUsuario = reserva.getUsuario().getNome();
        this.tituloLivro = reserva.getLivro().getTitulo();
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

    public Integer getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(Integer statusReserva) {
        this.statusReserva = statusReserva;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public long getLivro() {
        return livro;
    }

    public void setLivro(long livro) {
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
