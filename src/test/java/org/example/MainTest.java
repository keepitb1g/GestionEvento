package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void verificarEdad() {
    }

    @Test
    void validarInvitados() {
    }

    @Test
    void aforoDisponible() {
    }

    @Test
    void permitirAcceso() {
    }

    @Test
    void ingresoPersona() {
    }

    @Test
    void removerPersona() {
    }
}