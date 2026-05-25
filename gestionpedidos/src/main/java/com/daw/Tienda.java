package com.daw;

import java.time.LocalDate;

public class Tienda {
    public Factura realizarVenta(Cliente c, Pedido p){
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
        return f;
    }
}
