package pe.edu.pe.grupo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Noticia")
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNoticias;

    @Column(name= "titulo", nullable = false, length = 20)
    private String titulo;

    @Column(name = "informacion", nullable = false)
    private String informacion;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "consejos", nullable = false)
    private String consejos;

    public Noticias() {}

    public Noticias(int idNoticias, String titulo, String informacion, LocalDate fechaPublicacion, String tipo, String consejos) {
        this.idNoticias = idNoticias;
        this.titulo = titulo;
        this.informacion = informacion;
        this.fechaPublicacion = fechaPublicacion;
        this.tipo = tipo;
        this.consejos = consejos;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsejos() {
        return consejos;
    }

    public void setConsejos(String consejos) {
        this.consejos = consejos;
    }
}
