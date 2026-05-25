package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    @DisplayName("Test del constructor de la clase Pedido")
    @Test
    public void testConstructor() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        assertEquals(2, p.getIdPedido());
        assertNotNull(p.getCliente());
        assertNotNull(p.getProductos());
        assertNotNull(p.getCantidades());
    }
    @DisplayName("Test de getters y setters de la clase Pedido")
    @Test
    public void testGettersSetters() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        p.setIdPedido(3);
        assertEquals(3, p.getIdPedido());
        p.setCliente(new Cliente(6, "pepe", 0, false, "España"));
        assertNotNull(p.getCliente());
    }
    @DisplayName("Test de añadir nuevo producto a la clase Pedido")
    @Test
    public void testAddProducto() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        Producto producto1 = new Producto(1, "producto1", 10);
        p.addProducto(producto1, 2);
        assertEquals(1, p.getProductos().size());
        assertEquals(2, p.getCantidades().get(producto1.getId()));
        Producto producto2 = new Producto(2, "producto2", 20);
        p.addProducto(producto2, 3);
        assertEquals(2, p.getProductos().size());
    }
    @DisplayName("Test de añadir un producto que ya existe en la clase Pedido")
    @Test
    public void testAddProductoExistente() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        Producto producto1 = new Producto(1, "producto1", 10);
        p.addProducto(producto1, 2);
        p.addProducto(producto1, 3);
        assertEquals(1, p.getProductos().size());
        assertEquals(5, p.getCantidades().get(producto1.getId()));
    }
    @DisplayName("Test de eliminar un producto de la clase Pedido")
    @Test
    public void testRemoveProducto() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        Producto producto1 = new Producto(1, "producto1", 10);
        p.addProducto(producto1, 3);
        p.quitarProducto(producto1,2);
        assertEquals(1, p.getProductos().size());
        assertEquals(1, p.getCantidades().get(producto1.getId()));
        p.quitarProducto(producto1);
        assertEquals(0, p.getProductos().size());
        p.addProducto(producto1, 1);
        p.quitarProducto(producto1,1);
        assertEquals(0, p.getProductos().size());
    }
    @DisplayName("Pruebas de excepciones con listado de productos")
    @Test
    public void testExcepciones() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        Producto producto1 = new Producto(1, "producto1", 10);
        Producto producto1duplicado = new Producto(1, "producto2", 10);
        assertThrows(IllegalArgumentException.class, () -> {
            p.addProducto(producto1, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.addProducto(producto1, 1);
            p.addProducto(producto1duplicado, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.addProducto(null, 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.quitarProducto(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.quitarProducto(null,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.quitarProducto(producto1, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.addProducto(producto1,1);
            p.quitarProducto(new Producto(20, "hola", 2), 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.addProducto(producto1,1);
            p.quitarProducto(new Producto(20, "hola", 2));
        });

    }
    @DisplayName("Test de calculo de precio total de la clase Pedido")
    @Test
    public void testCalculoPrecioTotal() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        Producto producto1 = new Producto(1, "producto1", 10);
        Producto producto2 = new Producto(2, "producto2", 20);
        p.addProducto(producto1, 3);
        p.addProducto(producto2, 2);
        assertEquals(70, p.calcularTotal(),0.01);
    }
    @DisplayName("Test de calculo del envio de la clase Pedido")
    @Test
    public void testCalculoEnvio() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "Portugal"));
        ProductoFisico producto1 = new ProductoFisico(1, "producto1", 10,5);
        ProductoFisico producto2 = new ProductoFisico(2, "producto2", 20,7);
        Producto extra = new Producto(3, "extra", 5);
        p.addProducto(producto1, 3);
        p.addProducto(producto2, 2);
        p.addProducto(extra, 3);
        assertEquals(7.9, p.calcularEnvio(p.getCliente().getPais()),0.01);
    }
    @DisplayName("Test de calculo del IVA de la clase Pedido")
    @Test
    public void testCalculoIVA() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        ProductoDigital producto1 = new ProductoDigital(1, "producto1", 10);
        ProductoDigital producto2 = new ProductoDigital(2, "producto2", 20);
        Producto extra = new Producto(3, "extra", 5);
        p.addProducto(producto1, 3);
        p.addProducto(producto2, 2);
        p.addProducto(extra, 3);
        assertEquals(14.7, p.calcularIva("GENERAL"),0.01);
    }
    @DisplayName("Test de fallo de los calculos")
    @Test
    public void testCalculosFallo() {
        Pedido p= new Pedido(2, new Cliente(5, "juan", 0, false, "España"));
        assertThrows(IllegalArgumentException.class, () -> {
           p.calcularEnvio("España"); 
        });
        assertThrows(IllegalArgumentException.class, () -> {
           p.calcularIva("GENERAL");
        });
        assertThrows(IllegalArgumentException.class, () -> {
           p.calcularTotal();
        });
    }
    
    
    

}
