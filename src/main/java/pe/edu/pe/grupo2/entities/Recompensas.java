package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Recompensas")
public class Recompensas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensas;

    @Column(name = "nombreRecompensa", nullable = false, length = 200)
    private String nombreRecompensa;

    @Column(name = "descripcionRecompensa", nullable = false, length = 200)
    private String descripcionRecompensa;


    @Column(name = "fechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name="idActividad")
    private Actividad ac;

    public Recompensas() {
    }

    public Recompensas(int idRecompensas, String nombreRecompensa, LocalDate fechaVencimiento,String descripcionRecompensa) {
        this.idRecompensas = idRecompensas;
        this.nombreRecompensa = nombreRecompensa;
        this.fechaVencimiento = fechaVencimiento;
        this.descripcionRecompensa = descripcionRecompensa;
    }

    public int getIdRecompensas() {
        return idRecompensas;
    }

    public void setIdRecompensas(int idRecompensas) {
        this.idRecompensas = idRecompensas;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }


    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Actividad getAc() {
        return ac;
    }

    public void setAc(Actividad ac) {
        this.ac = ac;
    }

    public String getDescripcionRecompensa() {
        return descripcionRecompensa;
    }

    public void setDescripcionRecompensa(String descripcionRecompensa) {
        this.descripcionRecompensa = descripcionRecompensa;
    }
}
