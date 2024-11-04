package comands;

public class AgregarReclamoCommand {
   private String usuarioCodigo;
   private int edificioCodigo;
   private String ubicacion;
   private int unidadCodigo;
   private String descripcion;
   private String tipoReclamo;
   private String estado;

    public AgregarReclamoCommand(String usuarioCodigo, int edificioCodigo, String ubicacion, int unidadCodigo, String descripcion, String tipoReclamo, String estado) {
        this.usuarioCodigo = usuarioCodigo;
        this.edificioCodigo = edificioCodigo;
        this.ubicacion = ubicacion;
        this.unidadCodigo = unidadCodigo;
        this.descripcion = descripcion;
        this.tipoReclamo = tipoReclamo;
        this.estado = estado;
    }

    public String getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public int getEdificioCodigo() {
        return edificioCodigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getUnidadCodigo() {
        return unidadCodigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public String getEstado() {
        return estado;
    }
}
