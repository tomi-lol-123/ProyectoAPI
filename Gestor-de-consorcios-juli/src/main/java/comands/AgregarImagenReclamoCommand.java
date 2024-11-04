package comands;

public class AgregarImagenReclamoCommand {
    private int numero;
    private String direccion;
    private String tipo;

    public AgregarImagenReclamoCommand(int numero, String direccion, String tipo) {
        this.numero = numero;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }
}
