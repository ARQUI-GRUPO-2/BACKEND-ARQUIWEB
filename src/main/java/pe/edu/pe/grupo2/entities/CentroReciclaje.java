package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "CentroReciclaje")
public class CentroReciclaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentroReciclaje;

    @Column(name = "direccion", nullable = false, length = 225)
    private String direccion;

    @Column(name = "latitud", nullable = false, length = 100)
    private String latitud;

    @Column(name = "longitud", nullable = false, length = 2100)
    private String longitud;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "favoritos")
    private Boolean favoritos;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User us;

    public CentroReciclaje() {

    }

    public CentroReciclaje(int idCentroReciclaje, String direccion, String latitud, String longitud, String tipoReciclaje, String horario, Boolean favoritos, User us) {
        this.idCentroReciclaje = idCentroReciclaje;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.horario = horario;
        this.favoritos = false;
        this.us = us;
    }
    
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

    public String getHorario() {return horario;}

    public void setHorario(String horario) {this.horario = horario;}

    public Boolean getFavoritos() { return favoritos; }

    public void setFavoritos(Boolean favoritos) { this.favoritos = favoritos; }

    public User getUs() { return us;}

    public void setUs(User us) { this.us = us;}
}
