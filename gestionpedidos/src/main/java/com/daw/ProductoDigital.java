package com.daw;

public class ProductoDigital extends Producto{
    /**
     * Constructor de la clase ProductoDigital
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     * @param precioBase Precio base del producto
     * @throws IllegalArgumentException Si el precio base es negativo
     */
    public ProductoDigital(int id, String nombre, double precioBase) throws IllegalArgumentException{
        super(id, nombre, precioBase);
    }
    /**
     * Método para aplicar el IVA al precio base del producto
     * @param tipoIva Tipo de IVA a aplicar: "GENERAL", "REDUCIDO" o "SUPER"
     * @return Valor del IVA aplicado
     * @throws IllegalArgumentException Si el tipo de IVA no coincide
     */
    public double aplicarIVA(String tipoIva)throws IllegalArgumentException{
        switch (tipoIva) {
            case "GENERAL" -> {
                return getPrecioBase()*0.21;
            }
            case "REDUCIDO" -> {
                return getPrecioBase()*0.1;
            }
            case "SUPER" -> {
                return getPrecioBase()*0.04;
            }
            default -> throw new IllegalArgumentException("Tipo de IVA no válido");
        }
    }
}
