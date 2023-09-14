package com.elementary.spring.mvc.dto.pedidos;

public class PedidoFindByUserEmpresaRequestDto {
    private int userId;
    private int empresaId;

    public PedidoFindByUserEmpresaRequestDto(){}
    public PedidoFindByUserEmpresaRequestDto(int userId, int empresaId) {
        this.userId = userId;
        this.empresaId = empresaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public String toString() {
        return "PedidoFindByUserEmpresaRequestDto{" +
                "userId=" + userId +
                ", empresaId=" + empresaId +
                '}';
    }
}
