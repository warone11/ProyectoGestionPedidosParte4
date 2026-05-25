package com.daw;

public class ProductoFisico extends Producto{
    private double peso;
    /**
     * Constructor de la clase ProductoFisico
     * @param id Identificador del producto
     * @param nombre Nombre del producto
     * @param precioBase Precio base del producto
     * @param peso Peso del producto 
     * @throws IllegalArgumentException Si el precio base es negativo
     * @throws IllegalArgumentException Si el peso es negativo
     */
    public ProductoFisico(int id, String nombre, double precioBase, double peso) throws IllegalArgumentException {
        super(id, nombre, precioBase);
        if(peso<0){
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        this.peso=peso;
    }
    /**
     * Calcula el coste de envio del producto
     * @param paisDestino Pais de destino del producto
     * @return Coste de envio del producto
     * @throws IllegalArgumentException Si el pais de destino es nulo o esta vacio
     */
    public static double costeEnvio(double peso,String paisDestino){
        if(paisDestino==null||paisDestino.isBlank())
            throw new IllegalArgumentException("El pais no puede ser nulo o estar vacio");
        double costePeso= peso*0.1;
        switch (paisDestino.toLowerCase()) {
            case "españa": return 0;
            case "francia","portugal","italia": return 5+costePeso;
            default:
                return 10+costePeso;
        }
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso)throws IllegalArgumentException {
        if(peso<0)
            throw new IllegalArgumentException("El peso no puede ser negativo");
        this.peso = peso;
    }

    
}
