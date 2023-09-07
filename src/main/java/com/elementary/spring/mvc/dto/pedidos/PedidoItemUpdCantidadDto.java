package com.elementary.spring.mvc.dto.pedidos;

public class PedidoItemUpdCantidadDto {
    private int id;
    private Long cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
