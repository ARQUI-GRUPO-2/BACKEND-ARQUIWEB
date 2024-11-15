package pe.edu.pe.grupo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name= "Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificaciones;

    @Column(name="mensaje", nullable = false, length = 225)
    private String mensaje;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idNoticias")
    private Noticias noti;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User us;

    public Notificaciones() {

    }

    public Notificaciones(int idNotificaciones, String mensaje, LocalDate fecha,Noticias noti, User us ) {
        this.idNotificaciones = idNotificaciones;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.noti = noti;
        this.us = us;
    }

    public int getIdNotificaciones() {
        return idNotificaciones;
    }

    public void setIdNotificaciones(int idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Noticias getNoti() {
        return noti;
    }

    public void setNoti(Noticias noti) {
        this.noti = noti;
    }

    public User getUs() {return us;}

    public void setUs(User us) {this.us = us;}
}
