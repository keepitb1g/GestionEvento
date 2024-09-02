package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(9,aforo);
        aforo = Main.aforoDisponible(lista,15);
                //aforo para entrada VIP
        assertEquals(7,aforo);
    }

    @Test
    void testPermitirAcceso() {
        boolean permiso = Main.permitirAcceso(lista,0);
        assertTrue(permiso);
        permiso = Main.permitirAcceso(lista,1);
        assertFalse(permiso);
    }

    @Test
    void testIngresoPersona() {
        lista = Main.ingresoPersona(lista, "Carlos");
        assertEquals("True", lista[2][4]);
    }

    @Test
    void testRemoverPersona() {
        Main.removerPersona(lista, "Joaquin");
        assertEquals("False", lista[0][4]);
    }
    @Test
    void testAforo(){
        assertEquals(9, Main.aforoDisponible(lista,10));
        // para comprobar aforo disponible en general
        assertEquals(7, Main.aforoDisponible(lista,15));
        // para comprobar aforo VIP
        Main.ingresoPersona(lista,"José");
        assertEquals("True", lista[8][4]);
        Main.ingresoPersona(lista, "Carlos");
        assertEquals("True",lista[2][4]);

        assertEquals(8,Main.aforoDisponible(lista,10));
        //se comprueba nuevo aforo General teniendo en cuenta que se ingreso un general
        assertEquals(4,Main.aforoDisponible(lista,15));
        //se comprueba nuevo aforo VIP teniendo en cuenta que se ingreso un VIP con 2 invitados


    }
}