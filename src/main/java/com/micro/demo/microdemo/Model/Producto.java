package com.micro.demo.microdemo.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Producto {

    @Id
    private String id;
    private String nombre;  // Asegúrate de que esta propiedad existe
    private double precio;
    private int cantidad;

    // Constructor
    public Producto() {
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'precio'
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getter y Setter para 'cantidad'
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
