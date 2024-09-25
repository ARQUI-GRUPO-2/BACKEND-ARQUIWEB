package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_de_actividad")
public class TipoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_actividad;
    @Column(name = "invitacion",nullable = false,length = 225)
    private Boolean invitacion;
    @Column(name = "reciclar",nullable = false,length = 225)
    private Boolean reciclar;

    public TipoActividad() {
    }
    public TipoActividad(int id_tipo_actividad, Boolean invitacion, Boolean reciclar) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.invitacion = invitacion;
        this.reciclar = reciclar;
    }

    public int getId_tipo_actividad() {return id_tipo_actividad;}

    public void setId_tipo_actividad(int id_tipo_actividad) {this.id_tipo_actividad = id_tipo_actividad;}

    public Boolean getInvitacion() {return invitacion;}

    public void setInvitacion(Boolean invitacion) {this.invitacion = invitacion;}

    public Boolean getReciclar() {return reciclar;}

    public void setReciclar(Boolean reciclar) {this.reciclar = reciclar;}
}
