package com.daw;

public class Producto {
    private int id;
    private String nombre;
    private double precioBase;
    /**
     * Constructor de la clase Producto
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     * @param precioBase Precio base del producto
     * @throws IllegalArgumentException Si el precio base es negativo
     */
    public Producto(int id, String nombre, double precioBase) throws IllegalArgumentException{
        this.id = id;
        this.nombre = nombre;
        if(precioBase < 0)
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        this.precioBase = precioBase;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    public void setPrecioBase(double precioBase)throws IllegalArgumentException {
        if(precioBase < 0)
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        this.precioBase = precioBase;
    }


}
