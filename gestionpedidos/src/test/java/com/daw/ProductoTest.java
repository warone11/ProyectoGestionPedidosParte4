package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    @DisplayName("Test de Constructor de la Clase Producto")
    @Test
    public void testConstructor(){
        Producto p= new Producto(2, "Tomate", 0.35);
        assertEquals(2, p.getId());
        assertEquals("Tomate", p.getNombre());
        assertEquals(0.35, p.getPrecioBase(),0.001);
    }
    @DisplayName("Constructor falla cuando se mete precio negativo")
    @Test
    public void testConstructorPrecioNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{
            Producto p= new Producto(2, "Tomate", -0.35);
        });
    }
    @DisplayName("Test de Getters y Setters de la Clase Producto")
    @Test
    public void testGettersSetters(){
        Producto p= new Producto(2, "Tomate", 0.35);
        p.setId(3);
        p.setNombre("Pimiento");
        p.setPrecioBase(0.45);
        assertEquals(3, p.getId());
        assertEquals("Pimiento", p.getNombre());
        assertEquals(0.45, p.getPrecioBase(),0.001);
        assertThrows(IllegalArgumentException.class, ()->{
            p.setPrecioBase(-0.45);
        });
    }
    
}
