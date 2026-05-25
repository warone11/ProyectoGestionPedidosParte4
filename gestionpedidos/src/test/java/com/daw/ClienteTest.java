package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClienteTest {
    @DisplayName("Test del constructor de la clase Cliente")
    @Test
    public void testConstructor(){
        Cliente c= new Cliente(56, "Juan", 3, true, "España");
        assertEquals(56, c.getId());
        assertEquals("Juan", c.getNombre());
        assertEquals(3, c.getAnyosAntiguedad());
        assertEquals(true, c.isEsVip());
        assertEquals("España", c.getPais());
    }
    @DisplayName("Test de getters y setters de la clase Cliente")
    @Test
    public void testGettersSetters(){
        Cliente c= new Cliente(56, "Juan", 3, true, "España");
        c.setId(5);
        c.setNombre("Pepe");
        c.setAnyosAntiguedad(2);
        c.setEsVip(false);
        c.setPais("Francia");
        
        assertEquals(5, c.getId());
        assertEquals("Pepe", c.getNombre());
        assertEquals(2, c.getAnyosAntiguedad());
        assertEquals(false, c.isEsVip());
        assertEquals("Francia", c.getPais());
    }
    @DisplayName("Test de calculo de descuento de la clase Cliente")
    @ParameterizedTest
    @CsvSource({"false, 3, 0","true, 3, 0.03", "false, 10, 0.03","true, 10, 0.06"})
    public void testCalculoDescuento(boolean esVip, int anyosAntiguedad, double descuentoEsperado){
        Cliente c= new Cliente(56, "Juan", anyosAntiguedad, esVip, "España");
        assertEquals(descuentoEsperado, c.obtenerDescuento(), 0.001);
        
    }
    
}
