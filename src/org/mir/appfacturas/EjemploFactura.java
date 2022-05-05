package org.mir.appfacturas;

import org.mir.appfacturas.modelo.Cliente;
import org.mir.appfacturas.modelo.Factura;
import org.mir.appfacturas.modelo.ItemFactura;
import org.mir.appfacturas.modelo.Producto;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente =new Cliente();
        cliente.setDNI("12345");
        cliente.setNombre("Carlos");

        Scanner sc = new Scanner(System.in);
        System.out.println(" Ingrese una descripcion factura");
        String desc = sc.nextLine();
        Factura factura = new Factura(cliente, desc);

        Producto producto;
        String nombre;
        double precio;
        int cantidad;

        System.out.println();
        for (int i=0; i<5; i++){
            producto = new Producto();
            System.out.println("Ingrese producto nº " + producto.getCodigo() + "");
            nombre = sc.next();
            producto.setNombre(nombre);

            System.out.println("Ingrese precio nº ");
            precio = sc.nextDouble();
            producto.setPrecio(precio);

            System.out.println("Ingrese cantidad nº ");
            cantidad = sc.nextInt();

            ItemFactura item = new ItemFactura(producto,cantidad);
            factura.addItemFactura(item);

            System.out.println();

        }
        System.out.println(factura.detalle());
    }
}
