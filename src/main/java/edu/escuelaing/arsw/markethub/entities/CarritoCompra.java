package edu.escuelaing.arsw.markethub.entities;

public class CarritoCompra {

    private String usuario;
    private Producto producto;
    private Integer cantidad;

    public CarritoCompra(){
        //Constructor vació
    }

    public CarritoCompra(String usuario, Producto producto, Integer cantidad) {
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
