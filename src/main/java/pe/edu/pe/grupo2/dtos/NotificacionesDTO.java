package pe.edu.pe.grupo2.dtos;

import jakarta.persistence.Column;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class NotificacionesDTO {
    private int idNotificacion;
    private String mensaje;
    private LocalDate fecha;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
