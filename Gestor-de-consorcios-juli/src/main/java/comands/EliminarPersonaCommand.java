package comands;

public class EliminarPersonaCommand {
    private String documento;

    public EliminarPersonaCommand(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }
}
