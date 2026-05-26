package com.daw;

import java.time.LocalDate;

public class Tienda {
    /**
     * Realiza una venta
     * @param c Cliente
     * @param p Pedido
     * @return Factura generada
     * @throws IllegalArgumentException si el cliente o el pedido es nulo
     */
    public Factura realizarVenta(Cliente c, Pedido p) throws IllegalArgumentException{
        if(c==null||p==null){
            throw new IllegalArgumentException("Cliente y pedido no pueden ser nulos");
        }
        Factura f = new Factura();
        f.codigoFactura=(int)(Math.random()*1000000000);
        //fecha actual
        f.fechaEmision=LocalDate.now();
        f.totalNeto=p.calcularTotal();
        f.totalEnvio=p.calcularEnvio(c.getPais());
        f.totalIva=p.calcularIva("GENERAL");
        
        f.totalFinal=f.totalNeto+f.totalEnvio+f.totalIva;
        f.descuento=c.obtenerDescuento()*f.totalFinal;
        f.totalFinal-=f.descuento;
        return f;
    }
}
