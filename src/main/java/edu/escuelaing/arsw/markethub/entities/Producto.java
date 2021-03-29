package edu.escuelaing.arsw.markethub.entities;

import java.util.List;

/**
 * Clase Producto
 */
public class Producto {

    private Integer id;
    private Categoria categoria;
    private String nombre;
    private List<Imagen> imagenes;
    private Integer precio;
    private String descripcion;
    private Double puntaje;
    private Integer cantidad;

    /**
     * Constructor vacio de la clase producto
     */
    public Producto() {
        // Constructor vacio
    }

    /**
     * Constructor con parámetros de la clase producto
     *
     * @param id          - id del producto
     * @param nombre      - nombre del producto
     * @param imagenes    - imagen del producto
     * @param precio      - precio del producto
     * @param descripcion - descripción del producto
     * @param puntaje     - puntaje del producto
     * @param cantidad    - cantidad de unidades disponibles del producto
     */
    public Producto(Integer id, Categoria categoria, String nombre, List<Imagen> imagenes, Integer precio,
            String descripcion, Double puntaje, Integer cantidad) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.imagenes = imagenes;
        this.precio = precio;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.cantidad = cantidad;
    }

    /**
     * Constructor con parámetros de la clase producto sin imagenes
     *
     * @param id          - id del producto
     * @param nombre      - nombre del producto
     * @param imagen      - imagen del producto
     * @param precio      - precio del producto
     * @param descripcion - descripción del producto
     * @param puntaje     - puntaje del producto
     * @param cantidad    - cantidad de unidades disponibles del producto
     */
    public Producto(Integer id, Categoria categoria, String nombre, Integer precio, String descripcion, Double puntaje,
            Integer cantidad) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.cantidad = cantidad;
    }

    /**
     * Método get del atributo id
     *
     * @return - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método set del atributo id
     *
     * @param id - nuevo id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método get del atributo nombre
     *
     * @return - nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set del atributo nombre
     *
     * @param nombre - nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get del atributo imagen
     *
     * @return - imagen del producto
     */
    public List<Imagen> getImagenes() {
        return imagenes;
    }

    /**
     * Método set del atributo imagen
     *
     * @param imagenes - imagen nueva del producto
     */
    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * Método get del atributo precio
     *
     * @return - precio del producto
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * Método set del atributo precio
     *
     * @param precio
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * Método get del atributo descripción
     *
     * @return - descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método set del atributo descripción
     *
     * @param descripcion - nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método get del atributo puntaje
     *
     * @return - puntaje del producto
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * Metodo set del atributo puntaje
     *
     * @param puntaje - nuevo puntaje
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Método get del atributo cantidad
     *
     * @return - cantidad de unidades en stock
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Método set del atributo cantidad
     *
     * @param cantidad - nueva cantidad en stock
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método get del atributo categoría
     *
     * @return - categoría del articulo
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Método set del atributo categoría
     *
     * @param cantidad - nueva categoría
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}