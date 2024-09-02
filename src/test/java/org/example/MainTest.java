package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    String[][] lista;

    @BeforeEach
    void inicializarLista() {
        lista = Main.crearLista();
    }

    @Test
    void testCrearLista() {
        assertEquals("Joaquin", lista[0][0]);
        assertEquals("Matias", lista[9][0]);
    }

    @Test
    void testAgregarPersona() {
        String[][] listaTest = new String[10][5];
        Main.agregarPersona(listaTest, "Test", "20", "VIP", "2", "True");
        assertEquals("Test", listaTest[0][0]);
    }

    @Test
    void testVerificarBoleto() {
        assertEquals("VIP", Main.verificarBoleto(lista, "Joaquin"));
        assertEquals("VIP", Main.verificarBoleto(lista, "Matias"));
    }

    @Test
    void testVerificarEdad() {
        assertTrue(Main.verificarEdad(lista, "Joaquin"));
        // Edad permitida
        assertFalse(Main.verificarEdad(lista, "Nawel"));
        // Edad no permitida
    }
    @Test
    void testAforoDisponible() {
        int aforo = Main.aforoDisponible(lista,10);
        //aforo para entrada general
        assertEquals(9,aforo);
        aforo = Main.aforoDisponible(lista,15);
        //aforo para entrada VIP
        assertEquals(7,aforo);
    }
}
