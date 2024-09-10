package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.User;

public class RolDTO {
    private int idRol;
    private String nombreRol;
    private String descripcionRol;
    private User user;


    public int getIdRol() {return idRol;}

    public void setIdRol(int idRol) {this.idRol = idRol;}

    public String getNombreRol() {return nombreRol;}

    public void setNombreRol(String nombreRol) {this.nombreRol = nombreRol;}

    public String getDescripcionRol() {return descripcionRol;}

    public void setDescripcionRol(String descripcionRol) {this.descripcionRol = descripcionRol;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
