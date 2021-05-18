package edu.escuelaing.arsw.markethub.entities;

import java.time.LocalDateTime;

public class Mensaje {

    private Integer id;
    private String emisor;
    private String receptor;
    private LocalDateTime fecha;
    private String contenido;
    private Boolean visto;

    public Mensaje(){
        //Constructor vacio
    }

    public Mensaje(Integer id, String emisor, String receptor, LocalDateTime fecha, String contenido, Boolean visto) {
        this.id = id;
        this.emisor = emisor;
        this.receptor = receptor;
        this.fecha = fecha;
        this.contenido = contenido;
        this.visto = visto;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }
}
