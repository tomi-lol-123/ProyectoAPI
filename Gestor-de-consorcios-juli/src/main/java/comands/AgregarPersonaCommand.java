package comands;

public class AgregarPersonaCommand {
    private String documento;
    private String nombre;

    public AgregarPersonaCommand(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }
}
