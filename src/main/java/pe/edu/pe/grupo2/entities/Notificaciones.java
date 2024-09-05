package pe.edu.pe.grupo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name= "Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificaciones;

    @Column(name="mensaje", nullable = false, length = 225)
    private String mensaje;

    @Column(name="estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalTime fecha;

    public Notificaciones() {}

    public Notificaciones(int idNotificaciones, String mensaje, String estado, LocalTime fecha) {
        this.idNotificaciones = idNotificaciones;
        this.mensaje = mensaje;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }
}
