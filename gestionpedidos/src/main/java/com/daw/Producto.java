package com.daw;

public class Producto {
    private int id;
    private String nombre;
    private double precioBase;
    public Producto(int id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        if(precioBase < 0)
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        this.precioBase = precioBase;
    }

}
