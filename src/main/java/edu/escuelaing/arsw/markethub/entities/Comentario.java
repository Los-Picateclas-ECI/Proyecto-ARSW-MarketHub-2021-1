package edu.escuelaing.arsw.markethub.entities;

public class Comentario {

    private String usuario;
    private Integer producto;
    private String contenido;

    public Comentario(){
        //Constructor vació
    }

    public Comentario(String usuario, Integer producto, String contenido) {
        this.usuario = usuario;
        this.producto = producto;
        this.contenido = contenido;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
