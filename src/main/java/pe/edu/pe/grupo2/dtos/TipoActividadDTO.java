package pe.edu.pe.grupo2.dtos;

public class TipoActividadDTO {
    private int id_tipo_de_actividad;
    private Boolean invitacion;
    private Boolean reciclar;

    public int getId_tipo_de_actividad() {return id_tipo_de_actividad;}

    public void setId_tipo_de_actividad(int id_tipo_de_actividad) {this.id_tipo_de_actividad = id_tipo_de_actividad;}

    public Boolean getInvitacion() {
        return invitacion;
    }

    public void setInvitacion(Boolean invitacion) {
        this.invitacion = invitacion;
    }

    public Boolean getReciclar() {
        return reciclar;
    }

    public void setReciclar(Boolean reciclar) {
        this.reciclar = reciclar;
    }
}
