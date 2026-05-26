package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TiendaTest {
    @DisplayName("Test de Realizar venta")
    @ParameterizedTest
    @CsvSource({
        "3,false,España,5.0,3,10.0,2,7.0,3,5.0,56.0,1.5,4.2,0.0,61.7",
        "6,true,Portugal,3.0,4,8.0,3,4.0,1,6.0,40.0,5.6,5.04,3.04,47.60",
        "2,true,Alemania,2.0,6,4.0,7,5.0,2,5.0,50.0,11.0,5.88,2.0,64.87"
        
    }
    )
    public void testRealizarVenta(int anyosAntiguedad, boolean esVip, String pais, double precioAbstracto, int cantidadAbstracto, double precioDigital, int cantidadDigital, double precioFisico, int cantidadFisico, double pesoFisico, double netoEsperado, double envioEsperado, double ivaEsperado, double descuentoEsperado, double totalEsperado) {
        Tienda t= new Tienda();
        Cliente c= new Cliente(3, "Juan", anyosAntiguedad, esVip, pais);
        Pedido p = new Pedido(4, c);
        p.addProducto(new Producto(1, "Producto Abstracto", precioAbstracto), cantidadAbstracto);
        p.addProducto(new ProductoDigital(2, "Producto digital", precioDigital), cantidadDigital);
        p.addProducto(new ProductoFisico(3, "Producto fisico", precioFisico, pesoFisico), cantidadFisico);
        Factura f= t.realizarVenta(c,p);
        assertEquals(netoEsperado,f.totalNeto,0.01);
        assertEquals(envioEsperado,f.totalEnvio,0.01);
        assertEquals(ivaEsperado, f.totalIva, 0.01);
        assertEquals(descuentoEsperado,f.descuento, 0.01);
        assertEquals(totalEsperado, f.totalFinal,0.01);
        String facturaString = f.toString();
        assertNotNull(facturaString);
    }
    @DisplayName("Realizar Venta falla con valores nulos")
    @Test
    public void testRealizarVentaFallos(){
        Tienda t= new Tienda();
        Cliente c= new Cliente(3, "Juan", 6, true, "portugal");
        Pedido p = new Pedido(4, c);
        assertThrows(IllegalArgumentException.class, ()->t.realizarVenta(null, p));
        assertThrows(IllegalArgumentException.class, ()->t.realizarVenta(c, null));
    }
    
}
