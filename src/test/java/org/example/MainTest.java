package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    String[][] lista = Main.crearLista();
    @BeforeEach
    void inicializarLista(){
        lista = Main.crearLista();
    }
    @Test
    void testCrearLista(){
        assertEquals("Joaquin", lista[0][0]);
        assertEquals("Matias",lista[9][0]);
    }
    @Test
    void testAgregarPersona() {
        String[][] listaTest = new String[10][5];
        Main.agregarPersona(listaTest, "Test", "0","VIP","2","True");
        assertEquals("Test", listaTest[0][0]);assertEquals("0", listaTest[0][1]);assertEquals("VIP", listaTest[0][2]);
        assertEquals("2", listaTest[0][3]);assertEquals("True", listaTest[0][4]);
    }


    @Test
    void testVerificarBoleto() {
        String resultado = Main.verificarBoleto(lista, "Joaquin");
        assertEquals("VIP", resultado);
        resultado = Main.verificarBoleto(lista, "Matias");
        assertEquals("True", resultado);
    }

    @Test
    void testVerificarEdad() {
        boolean resultado = Main.verificarEdad(lista, "Joaquin");
        assertTrue(resultado);
        resultado = Main.verificarEdad(lista, "Matias");
        assertTrue(resultado);
    }

    @Test
    void testValidarInvitados() {
        String resultado = Main.validarInvitados(lista, "Joaquin");
        assertEquals("Permitido", resultado);
        resultado = Main.validarInvitados(lista, "Lukas");
        assertEquals("El nombre ingresado no posee boleto VIP", resultado);
        resultado = Main.validarInvitados(lista, "Felipe");
        assertEquals("Excede el máximo de invitados para el boleto VIP", resultado);

    }

    @Test
    void testAforoDisponible() {
        int aforo = Main.aforoDisponible(lista,10);
                //aforo para entrada general
        assertEquals(3,aforo);
        aforo = Main.aforoDisponible(lista,15);
                //aforo para entrada VIP
        assertEquals(15,aforo);
    }

    @Test
    void testPermitirAcceso() {
    }

    @Test
    void testIngresoPersona() {
    }

    @Test
    void testRemoverPersona() {
    }
}