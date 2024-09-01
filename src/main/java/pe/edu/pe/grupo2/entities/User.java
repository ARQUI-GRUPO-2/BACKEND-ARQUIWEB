package pe.edu.pe.grupo2.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nombres", nullable = false, length = 30)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    
    @Column(name = "edad", nullable = false, length = 3)
    private int edad;
    
    @Column(name = "genero", nullable = false, length = 9)
    private String genero;

    @Column(name = "informacionPersonal", nullable = false)
    private String informacionPersonal;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;
    
    public User() {

    }

    public User(int idUser, String nombres, String apellidos, String dni, int edad, String genero, String informacionPersonal, String direccion, String telefono, String correo, String contrasena) {
        this.idUser = idUser;
        this.nombres= nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad   ;
        this.genero = genero;
        this.informacionPersonal = informacionPersonal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = Integer.parseInt(edad);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getInformacionPersonal() {
        return informacionPersonal;
    }

    public void setInformacionPersonal(String informacionPersonal) {
        this.informacionPersonal = informacionPersonal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return nombres;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
