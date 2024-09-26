package pe.edu.pe.grupo2.dtos;

public class TipoActividadDTO {
    private int id_tipo_actividad;
    private String invitacion;
    private String reciclar;

    public int getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(int id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getInvitacion() {
        return invitacion;
    }

    public void setInvitacion(String invitacion) {
        this.invitacion = invitacion;
    }

    public String getReciclar() {
        return reciclar;
    }

    public void setReciclar(String reciclar) {
        this.reciclar = reciclar;
    }
}
