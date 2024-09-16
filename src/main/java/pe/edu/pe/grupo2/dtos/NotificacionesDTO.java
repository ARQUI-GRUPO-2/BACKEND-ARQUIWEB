package pe.edu.pe.grupo2.dtos;

import jakarta.persistence.Column;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalTime;

public class NotificacionesDTO {
    private int idNotificacion;
    private String mensaje;
    private Boolean estado;
    private LocalTime fecha;
    private Noticias noti;
    private User us;

    public int getIdNotificacion() {return idNotificacion;}

    public void setIdNotificacion(int idNotificacion) {this.idNotificacion = idNotificacion;}

    public String getMensaje() {return mensaje;}

    public void setMensaje(String mensaje) {this.mensaje = mensaje;}

    public Boolean getEstado() {return estado;}

    public void setEstado(Boolean estado) {this.estado = estado;}

    public LocalTime getFecha() {return fecha;}

    public void setFecha(LocalTime fecha) {this.fecha = fecha;}

    public Noticias getNoti() {return noti;}

    public void setNoti(Noticias noti) {this.noti = noti;}

    public User getUs() {return us;}

    public void setUs(User us) {this.us = us;}
}
