package com.gestor.API.services;

public class TransferirUnidadRequest {

    private int codigo;
    private String documento;

    public TransferirUnidadRequest(int codigo, String documento) {
        this.codigo = codigo;
        this.documento = documento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
