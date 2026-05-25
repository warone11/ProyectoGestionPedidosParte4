package com.daw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProductoDigitalTest {
    @DisplayName("Test de Constructor de la Clase ProductoDigital")
    @Test
    public void testConstructor() {
        ProductoDigital p= new ProductoDigital(5, "Producto Digital", 5);
        assertEquals(5, p.getId());
        assertEquals("Producto Digital", p.getNombre());
        assertEquals(5, p.getPrecioBase());
    }
    @DisplayName("Test de Método aplicarIVA de la Clase ProductoDigital")
    @ParameterizedTest
    @CsvSource(value = {"GENERAL, 2.1", "REDUCIDO, 1", "SUPER, 0.4"})
    public void testAplicarIVA(String tipo, double esperado) {
        ProductoDigital p= new ProductoDigital(5, "Producto Digital", 10);
        assertEquals(esperado, p.aplicarIVA(tipo),0.001);
    }
    @DisplayName("AplicarIVA falla cuando se mete tipo de IVA incorrecto")
    @Test
    public void testAplicarIVATipoIvaIncorrecto() {
        ProductoDigital p= new ProductoDigital(5, "Producto Digital", 10);
        assertThrows(IllegalArgumentException.class, () -> p.aplicarIVA("NO EXISTE"));
    }
}
