package com.biblioteca.domains.enums;

public enum StatusReserva {

    ATIVO(0,"ATIVO"), CANCELADA(1,"CANCELADA"), CONCLUIDA(2,"CONCLUIDA");

    private Integer id;
    private String statusReserva;

    private StatusReserva(Integer id, String statusReserva) {
        this.id = id;
        this.statusReserva = statusReserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public static StatusReserva toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for(StatusReserva x: StatusReserva.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status Reserva inválida!");
    }
}
