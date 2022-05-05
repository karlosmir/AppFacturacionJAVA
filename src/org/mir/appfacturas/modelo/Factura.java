package org.mir.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    // Atributos
    private Cliente cliente;
    private Date fecha;
    private ItemFactura[] items;
    private int indiceItems;
    private int folio;
    private String descripcion;
    public static final int MAX_ITEMS = 5;
    private static int ultimoFolio;

    // Constructor
    public Factura(Cliente cliente, String descripcion) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    // GET AND SET
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemFactura() {
        return items;
    }

    public void setItemFactura(ItemFactura[] items) {
        this.items = items;
    }

    // Metodos
    public void addItemFactura(ItemFactura item){
        if(indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }
    public double calcularTotal(){
        float total = 0;
        for (ItemFactura item: this.items){
            if (item == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String detalle(){
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio).append("\nCliente :").
                append(this.getCliente().getNombre()).
                append("\t NIF :").
                append(this.getCliente().getDNI()).
                append("\nDescripcion: ").append(this.getDescripcion()).
                append(("\nNombre :")).append(this.getCliente().getNombre());
        SimpleDateFormat df = new SimpleDateFormat("dd,'de', MMMM, yyyy" );
        sb.append(" \nFecha emision: ").append(df.format(this.fecha))
                .append("\n");

        for (ItemFactura item: this.items){
            if ( item == null){
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("\nGran Total :").append(calcularTotal());
        return sb.toString();

    }
}
