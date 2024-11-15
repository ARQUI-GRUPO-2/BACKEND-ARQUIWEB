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


    public Notificaciones() {

    }

    public Notificaciones(int idNotificaciones, String mensaje, LocalDate fecha) {
        this.idNotificaciones = idNotificaciones;
        this.mensaje = mensaje;
        this.fecha = fecha;
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
