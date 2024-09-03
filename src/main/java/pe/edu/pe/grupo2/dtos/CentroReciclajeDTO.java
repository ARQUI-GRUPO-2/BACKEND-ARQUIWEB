package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.User;

import java.time.LocalTime;

public class CentroReciclajeDTO {

    private int idCentroReciclaje;
    private String direccion;
    private String latitud;
    private String longitud;
    private LocalTime horario;
    private Boolean favoritos;
    private User us;

    public int getIdCentroReciclaje() {
        return idCentroReciclaje;
    }

    public void setIdCentroReciclaje(int idCentroReciclaje) {
        this.idCentroReciclaje = idCentroReciclaje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Boolean getFavoritos() { return favoritos; }

    public void setFavoritos(Boolean favoritos) { this.favoritos  = favoritos; }

    public User getUs() {return us; }

    public void setUs(User us) { this.us = us; }
}
