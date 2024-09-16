package pe.edu.pe.grupo2.dtos;

public class MoreActivityLessRecyclingDTO {
        public String direccion;
        public int totalActividades;
        public Double totalReciclado;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTotalActividades() {
        return totalActividades;
    }

    public void setTotalActividades(int totalActividades) {
        this.totalActividades = totalActividades;
    }

    public Double getTotalReciclado() {
        return totalReciclado;
    }

    public void setTotalReciclado(Double totalReciclado) {
        this.totalReciclado = totalReciclado;
    }
}
