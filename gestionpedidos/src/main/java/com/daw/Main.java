package com.daw;



public class Main {
    public static void main(String[] args) {
        int anyosAntiguedad =2;
        boolean esVip=true;
        String pais = "Alemania";
        double precioAbstracto=2;
        int cantidadAbstracto=6;
        double precioDigital=4;
        int cantidadDigital=7;
        double precioFisico=5;
        int cantidadFisico=2;
        double pesoFisico=5;
        testRealizarVenta(anyosAntiguedad, esVip, pais, precioAbstracto, cantidadAbstracto, precioDigital, cantidadDigital, precioFisico, cantidadFisico, pesoFisico);        
    }
    public static void testRealizarVenta(int anyosAntiguedad, boolean esVip, String pais, double precioAbstracto, int cantidadAbstracto, double precioDigital, int cantidadDigital, double precioFisico, int cantidadFisico, double pesoFisico) {
        Tienda t= new Tienda();
        Cliente c= new Cliente(3, "Juan", anyosAntiguedad, esVip, pais);
        Pedido p = new Pedido(4, c);
        p.addProducto(new Producto(1, "Producto Abstracto", precioAbstracto), cantidadAbstracto);
        p.addProducto(new ProductoDigital(2, "Producto digital", precioDigital), cantidadDigital);
        p.addProducto(new ProductoFisico(3, "Producto fisico", precioFisico, pesoFisico), cantidadFisico);
        Factura f= t.realizarVenta(c,p);
        System.out.println("\""+anyosAntiguedad+","+esVip+","+pais+","+precioAbstracto+","+cantidadAbstracto+","+precioDigital+","+cantidadDigital+","+precioFisico+","+cantidadFisico+","+pesoFisico+","+f.totalNeto+","+f.totalEnvio+","+f.totalIva+","+f.descuento+","+f.totalFinal+"\"");

    }
}
