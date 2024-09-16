package pe.edu.pe.grupo2.dtos;

public class ActividadesPorUsuarioDTO {
    private int id_user;
    private int numeroactividades;
    private int total_puntos;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getNumeroactividades() {
        return numeroactividades;
    }

    public void setNumeroactividades(int numeroactividades) {
        this.numeroactividades = numeroactividades;
    }

    public int getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(int total_puntos) {
        this.total_puntos = total_puntos;
    }
}
