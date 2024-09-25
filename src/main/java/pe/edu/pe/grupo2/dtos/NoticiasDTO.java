package pe.edu.pe.grupo2.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class NoticiasDTO {
    private int idNoticia;
    private String tituloNoticia;
    private String informacionNoticia;
    private LocalDate fechaPublicacion;

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getInformacionNoticia() {
        return informacionNoticia;
    }

    public void setInformacionNoticia(String informacionNoticia) {
        this.informacionNoticia = informacionNoticia;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
