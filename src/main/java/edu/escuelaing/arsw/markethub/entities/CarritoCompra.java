package edu.escuelaing.arsw.markethub.entities;

public class CarritoCompra {

    private String usuario;
    private Integer producto;
    private Integer cantidad;

    public CarritoCompra(){
        //Constructor vació
    }

    public CarritoCompra(String usuario, Integer producto, Integer cantidad) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
