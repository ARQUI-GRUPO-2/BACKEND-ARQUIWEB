package pe.edu.pe.grupo2.dtos;

import java.time.LocalTime;

public class tipo_actividadDTO {
    private int idtipoactividad;
    private String invitacion;
    private String reciclar;


    public int getIdtipoactividad() {
        return idtipoactividad;
    }

    public void setTipoactividad(int idtipoactividad) {
        this.idtipoactividad = idtipoactividad;
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
