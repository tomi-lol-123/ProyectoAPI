package comands;

public class CambiarEstadoCommand {
    private int numero;
    private String estado;

    public CambiarEstadoCommand(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }
}
