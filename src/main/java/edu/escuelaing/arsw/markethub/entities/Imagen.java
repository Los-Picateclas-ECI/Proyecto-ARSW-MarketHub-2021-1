package edu.escuelaing.arsw.markethub.entities;

public class Imagen {
    private int id;
    private Producto producto;
    private byte[] imagen;

    public Imagen() {

    }

    public Imagen(int id, Producto producto, byte[] imagen) {
        this.id = id;
        this.producto = producto;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
