package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;
    @Column(name = "fecha_recepcion",nullable = false, length = 225)
    private String fecha_recepcion;
    @Column(name = "descripcion",nullable = false, length = 500)
    private String descripcion;
    @Column(name = "nombre",nullable = false, length = 100)
    private String nombre;
    @Column(name = "puntos",nullable = false, length = 155)
    private String puntos;
    @Column(name = "cantidad",nullable = false, length = 150)
    private String cantidad;
    @Column(name = "ubicacion",nullable = false, length = 225)
    private String ubicacion;

    public Actividad() {}

    public Actividad(int idActividad, String fecha_recepcion, String descripcion, String nombre, String puntos, String cantidad, String ubicacion) {
        this.idActividad = idActividad;
        this.fecha_recepcion = fecha_recepcion;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;

    }


    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


}
