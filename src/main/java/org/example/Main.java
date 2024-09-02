package org.example;

public class Main {
    public static void main(String[] args) {
    }

    public static String[][] crearLista() {
        String[][] lista = new String[10][5];
        agregarPersona(lista, "Joaquin", "20", "VIP", "2", "True");
        agregarPersona(lista, "Nawel", "17", "General", "0", "False");
        agregarPersona(lista, "Carlos", "20", "VIP", "2", "False");
        agregarPersona(lista, "Felipe", "21", "VIP", "3", "False");
        agregarPersona(lista, "Tomás", "17", "False", "2", "False");
        agregarPersona(lista, "Nicolas", "20", "VIP", "1", "True");
        agregarPersona(lista, "Lukas", "20", "General", "1", "False");
        agregarPersona(lista, "Juan", "23", "False", "2", "False");
        agregarPersona(lista, "José", "26", "General", "0", "True");
        agregarPersona(lista, "Matias", "22", "VIP", "2", "True");
        return lista;
    }

    public static void agregarPersona(String lista[][], String nombre, String edad, String boleto, String invitados, String ingresado) {
        for (int i = 0; i < 10; i++) {
            if (lista[i][0] == null) {
                lista[i][0] = nombre;
                lista[i][1] = edad;
                lista[i][2] = boleto;
                lista[i][3] = invitados;
                lista[i][4] = ingresado;
                break;
            }
        }
    }

    public static String verificarBoleto(String[][] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                return lista[i][2];
            }
        }
        return "Error buscando el boleto.";
    }

    public static boolean verificarEdad(String[][] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                return Integer.parseInt(lista[i][1]) >= 18;
            }
        }
        return false;
    }

    public static String validarInvitados(String[][] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                if (!lista[i][2].equals("VIP")) {
                    return "El nombre ingresado no posee boleto VIP";
                }
                int invitados = Integer.parseInt(lista[i][3]);
                return invitados <= 2 ? "Permitido" : "Excede el máximo de invitados para el boleto VIP";
            }
        }
        return "El nombre ingresado no existe en la lista";
    }

    public static int aforoDisponible(String[][] lista, int aforo) {
        int aforoDisponible = aforo;

        if (aforoDisponible == 10) {
            for (int i = 0; i < 10; i++) {
                if (lista[i][2].equals("General") && lista[i][4].equals("True")) aforoDisponible--;
            }
        } else if (aforoDisponible == 15) {
            for (int i = 0; i < 10; i++) {
                if (lista[i][2].equals("VIP") && lista[i][4].equals("True")) {
                    aforoDisponible--;
                    String validarInvitados = validarInvitados(lista, lista[i][0]);
                    if (validarInvitados.equals("Permitido")) {
                        aforoDisponible -= Integer.parseInt(lista[i][3]);
                    }
                }
            }
        }
        return aforoDisponible;
    }

    public static boolean permitirAcceso(String[][] lista, int numeroFila) {
        String nombre = lista[numeroFila][0];
        boolean verificacionEdad = verificarEdad(lista, nombre);
        String boleto = verificarBoleto(lista, nombre);
        String invitados = validarInvitados(lista, nombre);

        boolean verificarAforo = false;
        if (boleto.equals("General")) {
            int aforo = aforoDisponible(lista, 10);
            if (invitados.equals("Permitido")) {
                int totalPersonas = 1 + Integer.parseInt(lista[numeroFila][3]);
                if (aforo > totalPersonas) verificarAforo = true;
            }
        }
        return verificacionEdad && !boleto.equals("False") && verificarAforo;
    }

    public static String[][] ingresoPersona(String[][] lista, String nombre) {
        for (int i = 0; i < 10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                if (lista[i][4].equals("False")) {
                } else {
                    System.out.println("Ya se encuentra dentro");
                }
            }
        }
        return lista;
    }

    public static String[][] removerPersona(String[][] lista, String nombre) {
        for (int i = 0; i < 10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                lista[i][4] = "False";
            }
        }
        return lista;
    }
}
