package com.daw;

import java.time.LocalDate;

public class Factura {
    public String codigoFactura;
    public LocalDate fechaEmision;
    public double totalNeto;
    public double totalIva;
    public double totalEnvio;
    public double totalFinal;
    public double descuento;



    @Override
    public String toString() {
        String txt="******************************************************\n"+
                "Factura: "+codigoFactura+"\n"+
                "Fecha de emision: "+fechaEmision+"\n"+
                "Total neto: "+totalNeto+"\n"+
                "Total IVA: "+totalIva+"\n"+
                "Total envio: "+totalEnvio+"\n"+
                "Descuento: "+descuento+"\n"+
                "Total final: "+totalFinal+"\n"+
                "******************************************************\n\n";
        return txt;
    }
}
