package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TiendaTest {
    @DisplayName("Test de Realizar venta")
    @Test
    public void testRealizarVenta() {
        Tienda t= new Tienda();
        Cliente c= new Cliente(3, "Juan", 6, true, "portugal");
        Pedido p = new Pedido(4, c);
        p.addProducto(new Producto(1, "Producto Abstracto", 5), 3);
        p.addProducto(new ProductoDigital(2, "Producto digital", 7), 2);
        p.addProducto(new ProductoFisico(3, "Producto fisico", 10, 5), 4);
        Factura f= t.realizarVenta(c,p);
        assertEquals(69,f.totalNeto,0.01);
        assertEquals(7,f.totalEnvio,0.01);
        assertEquals(2.94, f.totalIva, 0.01);
        

    }
    
}
