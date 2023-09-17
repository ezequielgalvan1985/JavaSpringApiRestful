package com.elementary.spring.mvc.dto.pedidos;

public class PedidoFindByUserAndEstadoRequestDto {
    private int userId;
    private int estadoId;


    public PedidoFindByUserAndEstadoRequestDto(int userId, int estadoId) {
        this.userId = userId;
        this.estadoId = estadoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public String toString() {
        return "PedidoFindByUserAndEstadoRequestDto{" +
                "userId=" + userId +
                ", estadoId=" + estadoId +
                '}';
    }
}
