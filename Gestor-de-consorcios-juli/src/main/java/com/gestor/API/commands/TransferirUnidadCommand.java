package com.gestor.API.commands;

public class TransferirUnidadCommand {

    private int codigo;
    private String documento;

    public TransferirUnidadCommand(int codigo, String documento) {
        this.codigo = codigo;
        this.documento = documento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDocumento() {
        return documento;
    }

}
