package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_de_actividad")
public class TipoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_actividad;
    @Column(name = "invitacion",nullable = false,length = 225)
    private String invitacion;
    @Column(name = "reciclar",nullable = false,length = 225)
    private String reciclar;

    public TipoActividad() {
    }
    public TipoActividad(int id_tipo_actividad, String invitacion, String reciclar) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.invitacion = invitacion;
        this.reciclar = reciclar;
    }

    public int getId_tipo_actividad() {return id_tipo_actividad;}

    public void setId_tipo_actividad(int id_tipo_actividad) {this.id_tipo_actividad = id_tipo_actividad;}

    public String getInvitacion() {
        return invitacion;
    }

    public void setInvitacion(String invitacion) {
        this.invitacion = invitacion;
    }

    public String getReciclar() {
        return reciclar;
    }

    public void setReciclar(String reciclar) {
        this.reciclar = reciclar;
    }
}
