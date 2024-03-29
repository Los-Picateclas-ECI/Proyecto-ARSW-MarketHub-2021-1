package edu.escuelaing.arsw.markethub.entities;

public class Categoria {

    private String nombre;
    private String descripcion;

    public Categoria() {
        // Constructor vacio
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Categoria [descripcion=");
        builder.append(descripcion);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append("]");
        return builder.toString();
    }
}
