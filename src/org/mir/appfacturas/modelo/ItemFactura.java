package org.mir.appfacturas.modelo;

import org.mir.appfacturas.modelo.Producto;

public class ItemFactura {
    // Atributos
    private Producto producto;
    private int cantidad;

    //Constructor
    public ItemFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // GET AND SET
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Metodos
    public double calcularImporte(){
        return  this.cantidad * this.producto.getPrecio();


    }
}
