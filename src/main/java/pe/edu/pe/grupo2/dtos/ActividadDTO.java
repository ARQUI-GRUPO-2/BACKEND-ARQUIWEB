package pe.edu.pe.grupo2.dtos;


import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.entities.TipoActividad;
import pe.edu.pe.grupo2.entities.User;

public class ActividadDTO {

    private int idActividad;
    private String fecha_recepcion;
    private String descripcion;
    private String nombre;
    private Double puntos;
    private String cantidad;
    private String ubicacion;

    private TipoActividad ta;
    private CentroReciclaje cr;
    private User u;

    public int getIdActividad() {return idActividad;}

    public void setIdActividad(int idActividad) {this.idActividad = idActividad;}

    public String getFecha_recepcion() {return fecha_recepcion;}

    public void setFecha_recepcion(String fecha_recepcion) {this.fecha_recepcion = fecha_recepcion;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getPuntos() {return puntos;}

    public void setPuntos(Double puntos) {this.puntos = puntos;}

    public String getCantidad() {return cantidad;}

    public void setCantidad(String cantidad) {this.cantidad = cantidad;}

    public String getUbicacion() {return ubicacion;}

    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}


    public TipoActividad getTa() {return ta;}
    public void setTa(TipoActividad ta) {this.ta = ta;}
    public CentroReciclaje getCr() {return cr;}
    public void setCr(CentroReciclaje cr) {this.cr = cr;}
    public User getU() {return u;}
    public void setU(User u) {this.u = u;}


}
