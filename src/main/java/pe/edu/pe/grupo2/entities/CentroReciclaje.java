package pe.edu.pe.grupo2.entities;
import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "CentroReciclaje")
public class CentroReciclaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentroReciclaje;

    @Column(name = "direccion", nullable = false, length = 225)
    private String direccion;

    @Column(name = "longitud", nullable = false, length = 2100)
    private String longitud;

    @Column(name = "latitud", nullable = false, length = 100)
    private String latitud;

    @Column(name = "tipoReciclaje", nullable = false, length = 50)
    private String tipoReciclaje;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    public CentroReciclaje() {

    }

    public CentroReciclaje(int idCentroReciclaje, String direccion, String longitud, String latitud, String tipoReciclaje, LocalTime horario) {
        this.idCentroReciclaje = idCentroReciclaje;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.tipoReciclaje = tipoReciclaje;
        this.horario = horario;
    }


    public int getIdCentroReciclaje() {
        return idCentroReciclaje;
    }

    public void setIdCentroReciclaje(int idCentroReciclaje) {
        this.idCentroReciclaje = idCentroReciclaje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getTipoReciclaje() {
        return tipoReciclaje;
    }

    public void setTipoReciclaje(String tipoReciclaje) {
        this.tipoReciclaje = tipoReciclaje;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
