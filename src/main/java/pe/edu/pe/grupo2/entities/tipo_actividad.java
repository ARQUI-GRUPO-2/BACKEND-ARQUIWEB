package pe.edu.pe.grupo2.entities;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

public class tipo_actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipoactividad;

    @Column(name = "invitacion", nullable = false, length = 225)
    private String invitacion;

    @Column(name = "reciclar", nullable = false, length = 2100)
    private String reciclar;


    public tipo_actividad() {

    }
    public tipo_actividad(int idtipoactividad, String invitacion, String reciclar) {
        this.idtipoactividad = idtipoactividad;
        this.invitacion = invitacion;
        this.reciclar = reciclar;

    }

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
