package org.mir.appfacturas.modelo;

public class Producto {
    // Atributos
    private int codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo;

    // Constructor
    public Producto() {
        this.codigo = ++ultimoCodigo;
    }

    //GET SET
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
