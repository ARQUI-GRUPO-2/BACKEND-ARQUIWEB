package pe.edu.pe.grupo2.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class NoticiasDTO {
    private int idNoticias;
    private String titulo;
    private String informacion;
    private LocalDate fechaPublicacion;

    public int getIdNoticias() {
        return idNoticias;
    }

    public void setIdNoticias(int idNoticias) {
        this.idNoticias = idNoticias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
