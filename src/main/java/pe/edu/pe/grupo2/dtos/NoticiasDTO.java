package pe.edu.pe.grupo2.dtos;

import java.time.LocalTime;

public class NoticiasDTO {
    private int idNoticia;
    private String tituloNoticia;
    private String informacionNoticia;
    private LocalTime fechaNoticia;
    private String tipoNoticia;
    private String consejo;

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

    public LocalTime getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(LocalTime fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    public String getTipoNoticia() {
        return tipoNoticia;
    }

    public void setTipoNoticia(String tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }
}
