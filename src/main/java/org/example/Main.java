package org.example;

public class Main {
    public static void main(String[] args) {
    }
    public static String[][] crearLista(){
        String[][] lista = new String[10][5];
        agregarPersona(lista, "Joaquin","20","VIP","2","True");
        agregarPersona(lista, "Nawel","17","General","0","False");
        agregarPersona(lista, "Carlos","20","VIP","2","False");
        agregarPersona(lista, "Felipe","21","VIP","3","False");
        agregarPersona(lista, "Tomás","17","False","2","False");
        agregarPersona(lista, "Nicolas","20","VIP","1","True");
        agregarPersona(lista, "Lukas","20","General","1","False");
        agregarPersona(lista, "Juan","23","False","2","False");
        agregarPersona(lista, "José","26","General","0","True");
        return lista;
    }
    public static void agregarPersona(String lista[][], String nombre, String edad, String entrada, String invitados, String ingresado){
        for (int i=0; i<=10; i++){
            lista[i][0]=nombre; lista[i][1]=edad; lista[i][2]=entrada; lista[i][3]=invitados; lista[i][4]=ingresado;

        }
    }
}