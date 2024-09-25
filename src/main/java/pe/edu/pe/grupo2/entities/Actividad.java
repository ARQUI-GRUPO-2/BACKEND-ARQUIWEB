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
    private Double puntos;
    @Column(name = "cantidad",nullable = false, length = 150)
    private String cantidad;
    @Column(name = "ubicacion",nullable = false, length = 225)
    private String ubicacion;
    @ManyToOne
    @JoinColumn(name = "id_tipo_de_actividad")
    private TipoActividad ta;

    @ManyToOne
    @JoinColumn(name = "idCentroReciclaje")
    private CentroReciclaje cr;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User u;
    public Actividad() {}

    public Actividad(int idActividad, String fecha_recepcion, String descripcion, String nombre, Double puntos, String cantidad, String ubicacion, TipoActividad ta, CentroReciclaje cr, User u) {
        this.idActividad = idActividad;
        this.fecha_recepcion = fecha_recepcion;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.ta = ta;
        this.cr = cr;
        this.u = u;

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

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
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
    public TipoActividad getTa() {return ta;}

    public void setTa(TipoActividad ta) {this.ta = ta;}

    public CentroReciclaje getCr() {return cr;}
    public void setCr(CentroReciclaje cr) {this.cr = cr;}

    public User getU() {return u;}
    public void setU(User u) {this.u = u;}
}
