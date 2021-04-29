package edu.escuelaing.arsw.markethub.entities;

public class CarritoCompra {

    private Integer id;
    private String usuario;
    private Producto producto;
    private Integer cantidad;

    public CarritoCompra(){
        //Constructor vació
    }

    public CarritoCompra(Integer id, String usuario, Producto producto, Integer cantidad) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
