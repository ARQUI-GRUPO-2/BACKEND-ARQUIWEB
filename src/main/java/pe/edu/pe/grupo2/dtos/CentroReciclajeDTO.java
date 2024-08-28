package pe.edu.pe.grupo2.dtos;

import java.time.LocalTime;

public class CentroReciclajeDTO {

    private int idCentroReciclaje;
    private String direccion;
    private String longitud;
    private String latitud;
    private String tipoReciclaje;
    private LocalTime horario;

    public int getIdCentroReciclaje() {
        return idCentroReciclaje;
    }

    public void setCentroReciclaje(int idCentroReciclaje) {
        this.idCentroReciclaje = idCentroReciclaje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getTipoReciclaje() {
        return tipoReciclaje;
    }

    public void setTipoReciclaje(String tipoReciclaje) {
        this.tipoReciclaje = tipoReciclaje;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

}
