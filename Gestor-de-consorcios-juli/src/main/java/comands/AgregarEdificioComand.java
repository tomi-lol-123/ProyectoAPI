package comands;

public class AgregarEdificioComand {
    private String nombre;
    private String direccion;

    public AgregarEdificioComand(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

}
