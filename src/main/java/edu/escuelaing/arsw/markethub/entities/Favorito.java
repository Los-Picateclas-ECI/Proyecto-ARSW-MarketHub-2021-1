package edu.escuelaing.arsw.markethub.entities;

public class Favorito {

    private String usuario;
    private Integer producto;

    public Favorito() {
        //Constructor vació
    }

    public Favorito(String usuario, Integer producto) {
        this.usuario = usuario;
        this.producto = producto;
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
}
