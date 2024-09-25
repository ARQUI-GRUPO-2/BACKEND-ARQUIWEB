package pe.edu.pe.grupo2.dtos;


public class UserDTO {
    private int idUser;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private String genero;
    private String informacionPersonal;
    private String distrito;
    private String telefono;
    private String correo;
    private Boolean enabled;

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

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

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

    public String getDistrito() {
        return distrito;
    }

    public void setDdistrito(String distrito) {
        this.distrito = distrito;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {return enabled;}

    public void setEnabled(Boolean enabled) {this.enabled = enabled;}
}
