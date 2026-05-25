package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoFisicoTest {
    @DisplayName("Test de Constructor de la Clase ProductoFisico")
    @Test
    public void testConstructor() {
        ProductoFisico p= new ProductoFisico(5, "Producto Fisico", 5, 3);
        assertEquals(5, p.getId());
        assertEquals("Producto Fisico", p.getNombre());
        assertEquals(5, p.getPrecioBase());
        assertEquals(3, p.getPeso());
    }
    @DisplayName("Constructor falla cuando se mete peso negativo o precio negativo")
    @Test
    public void testConstructorExcepciones() {
        assertThrows(IllegalArgumentException.class, () -> new ProductoFisico(5, "Producto Fisico", -5, 3));
        assertThrows(IllegalArgumentException.class, () -> new ProductoFisico(5, "Producto Fisico", 5, -3));
    }
    @DisplayName("Test de Getters y Setters de la Clase ProductoFisico")
    @Test
    public void testGettersSetters() {
        ProductoFisico p= new ProductoFisico(5, "Producto Fisico", 5, 3);
        p.setPeso(5);
        assertEquals(5, p.getPeso());
        assertThrows(IllegalArgumentException.class, () -> p.setPeso(-5));
    }
    @DisplayName("Test de costeEnvio de la Clase ProductoFisico")
    @Test
    public void testCosteEnvio() {
        assertEquals(0.5, ProductoFisico.costeEnvio(5, "España"), 0.01);
        assertEquals(5.3, ProductoFisico.costeEnvio(3, "Portugal"), 0.01);
        assertEquals(11, ProductoFisico.costeEnvio(10, "Alemania"), 0.01);
    }
    @DisplayName("Test de costeEnvio de la Clase ProductoFisico con excepciones")
    @Test
    public void testCosteEnvioExcepciones() {
        assertThrows(IllegalArgumentException.class, () -> ProductoFisico.costeEnvio(5, ""));
        assertThrows(IllegalArgumentException.class, () -> ProductoFisico.costeEnvio(5, null));
    }
}
