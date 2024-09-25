package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombreRol", nullable = false, length = 100)
    private String nombreRol;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Rol() {
    }

    public Rol(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {return idRol;}

    public void setIdRol(int idRol) {this.idRol = idRol;}

    public String getNombreRol() {return nombreRol;}

    public void setNombreRol(String nombreRol) {this.nombreRol = nombreRol;}

}
