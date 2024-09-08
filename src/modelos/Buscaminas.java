/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Random;

/**
 *
 * @author jfcs8
 */
public class Buscaminas {
    public final static int VACIO = 0;
    public final static int MINA = -1;
    public final static int VISTA_NO_OCUPADA = 176;
    public final static int NO_VISTA = 254;
    public final static int VISTA_MINA = 157;
    public final static int VISTA_MARCAR_BANDERA = 244;
    public final static int FILAS = 20;
    public final static int COLUMNAS = 20;
    int [][] solucion;
    char [][] vista;
    private boolean primerMovimiento = true;
    private boolean finJuego = false;
    private boolean banderaMarcada = false;
    private boolean descubierta = false;
    private int minasContador = 40;
    private int minasPuestas = minasContador;
    private int minaInicial = minasContador;

    public Buscaminas   (int [][] solucion, char[][] vista) {
        this.solucion = solucion;
        this.vista = vista;
    }

    public Buscaminas() {
        this.solucion = new int [FILAS][COLUMNAS];
        this.vista = new char[FILAS][COLUMNAS];
        iniciarMatrizSolucion();
        generarMina();
        iniciarVista();
        mostrarMatrizSolucion();
    }


    public int[][] getSolucion() {
        return solucion;
    }

    public void setSolucion(int[][] solucion) {
        this.solucion = solucion;
    }

    public char[][] getVista() {
        return vista;
    }

    public void setVista(char[][] vista) {
        this.vista = vista;
    }

    public int getMinas() {
        return minasContador;
    }

    public void setMinas(int minasContador) {
        this.minasContador = minasContador;
    }

    public int getMinasPuestas() {
        return minasPuestas;
    }

    public void setMinasPuestas(int minasPuestas) {
        this.minasPuestas = minasPuestas;
    }

    public int getMinaInicial() {
        return minaInicial;
    }
    
    
    

    public int numeroAleatorio(){
        int n = new Random().nextInt(1,19);
        return n;
    }

    public void mostrarMatrizSolucion(){
        int fila = 1 ;
        System.out.println("      1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20 ");
        for (int i = 0 ; i < solucion.length ; i++){
            System.out.printf("%2d",fila);
            fila++;
            for (int j = 0 ; j < solucion.length ; j++){
                System.out.printf(" | %2d",solucion[i][j]);
            }
            System.out.println(" |");
        }
    }

    public void iniciarVista(){
        for (int i = 0; i < vista.length; i++) {
            for (int j = 0; j < vista.length; j++) {
                vista[i][j] = NO_VISTA;
            }
        }
    }

    public void juego(int [] valores){

        movimientoInicial(valores);
     }

    public boolean isFinJuego(){
        return finJuego;
    }
    
    public void setFinJuego(boolean b){
        this.finJuego = b;
    }



    public void movimientoInicial(int [] valores) {

        if(vista[valores[0]][valores[1]] == VISTA_MARCAR_BANDERA){
            System.out.println("Movimiento incorrecto. Primero debe levantar la bandera.");
            return;
        }

        if(solucion[valores[0]][valores[1]] == MINA){
            vista[valores[0]][valores[1]] = VISTA_MINA;
            finJuego = true;
            return;
        }

        if(solucion[valores[0]][valores[1]] == 1){
            vista[valores[0]][valores[1]] = '1';
            return;
        }
        if(solucion[valores[0]][valores[1]] == 2){
            vista[valores[0]][valores[1]] = '2';
            return;
        }
        if(solucion[valores[0]][valores[1]] == 3){
            vista[valores[0]][valores[1]] = '3';
            return;
        }
        if(solucion[valores[0]][valores[1]] == 4){
            vista[valores[0]][valores[1]] = '4';
            return;
        }

        if(solucion[valores[0]][valores[1]] == VACIO){
            vista[valores[0]][valores[1]] = VISTA_NO_OCUPADA;
            int fila = valores[0];
            int col = valores[1];
            movimientoCero(fila,col);
        }


    }

    public void movimientoCero(int fila, int columna){
        if((fila-1 >= 0 && fila-1 <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 1
            if (solucion[fila - 1][columna - 1] == VACIO && vista[fila - 1][columna - 1] == NO_VISTA) {
                mostrarCasillas(fila - 1, columna - 1);
                movimientoCero(fila - 1, columna - 1);
            } else {
                mostrarCasillas(fila - 1, columna - 1);
            }
        }

        if((fila-1 >= 0 && fila-1 <= 19) && (columna >= 0 && columna <= 19)) {
            //posicion 2
            if (solucion[fila - 1][columna] == VACIO && vista[fila - 1][columna] == NO_VISTA) {
              mostrarCasillas(fila - 1, columna);
              movimientoCero(fila - 1, columna);
            } else {
              mostrarCasillas(fila - 1, columna);
            }
        }

        if((fila-1 >= 0 && fila-1 <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 3
            if (solucion[fila - 1][columna + 1] == VACIO && vista[fila - 1][columna + 1] == NO_VISTA) {
              mostrarCasillas(fila - 1, columna + 1);
              movimientoCero(fila - 1, columna + 1);
            } else {
              mostrarCasillas(fila - 1, columna + 1);
            }
        }

        if((fila >= 0 && fila <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 4
            if (solucion[fila][columna - 1] == VACIO && vista[fila][columna - 1] == NO_VISTA) {
              mostrarCasillas(fila, columna - 1);
              movimientoCero(fila, columna - 1);
            } else {
              mostrarCasillas(fila, columna - 1);
            }
        }

        if((fila >= 0 && fila <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 6
            if (solucion[fila][columna + 1] == VACIO && vista[fila][columna + 1] == NO_VISTA) {
              mostrarCasillas(fila, columna + 1);
              movimientoCero(fila, columna + 1);
            } else {
              mostrarCasillas(fila, columna + 1);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 7
            if (solucion[fila + 1][columna - 1] == VACIO && vista[fila + 1][columna - 1] == NO_VISTA) {
              mostrarCasillas(fila + 1, columna - 1);
              movimientoCero(fila + 1, columna - 1);
            } else {
              mostrarCasillas(fila + 1, columna - 1);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna >= 0 && columna <= 19)) {
            //posicion 8
            if (solucion[fila + 1][columna] == VACIO && vista[fila + 1][columna] == NO_VISTA) {
              mostrarCasillas(fila + 1, columna);
              movimientoCero(fila + 1, columna);
            } else {
              mostrarCasillas(fila + 1, columna);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 9
            if (solucion[fila + 1][columna + 1] == VACIO && vista[fila + 1][columna + 1] == NO_VISTA) {
              mostrarCasillas(fila + 1, columna + 1);
              movimientoCero(fila + 1, columna + 1);
            } else {
              mostrarCasillas(fila + 1, columna + 1);
            }
        }

    }


    private void mostrarCasillas(int fila, int columna){
        if(vista[fila][columna] == VISTA_MARCAR_BANDERA){
            System.out.println("Movimiento incorrecto. Primero debe levantar la bandera.");
            return;
        }

        if(solucion[fila][columna] == MINA){
            vista[fila][columna] = VISTA_MINA;
            finJuego = true;
            return;
        }

        if(solucion[fila][columna] == VACIO){
            vista[fila][columna] = VISTA_NO_OCUPADA;
            return;
        }
        if(solucion[fila][columna] == 1){
            vista[fila][columna] = '1';
            return;
        }
        if(solucion[fila][columna] == 2){
            vista[fila][columna] = '2';
            return;
        }
        if(solucion[fila][columna] == 3){
            vista[fila][columna] = '3';
            return;
        }
        if(solucion[fila][columna] == 4){
            vista[fila][columna] = '4';
            return;
        }
    }

    public void iniciarMatrizSolucion(){
        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion.length; j++) {
                solucion[i][j] = VACIO;
            }
        }
    }

    public void mostrarMatrizVista() {
        int fila = 1;
        System.out.println("      1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20 ");
        for (int i = 0; i < vista.length; i++) {
            System.out.printf("%2d", fila);
            fila++;
            for (int j = 0; j < vista.length; j++) {
                System.out.printf(" | %2s", vista[i][j]);
            }
            System.out.println(" |");
        }
    }

    public void generarMina() {
       while (minasContador > 0){
           int fila = numeroAleatorio();
           int columna = numeroAleatorio();
           if(solucion[fila][columna] == VACIO){
               solucion[fila][columna] = MINA;
               minasContador--;
               int posFila = fila - 1;
               int posColumna = columna - 1;
               for (int i = posFila ; i < posFila + 3 ; i++){
                   for(int j = posColumna ; j < posColumna + 3 ; j++){
                       if(solucion[i][j] != MINA){
                           solucion[i][j] += 1;
                       }
                   }
               }
           }
       }
    }

    public void colocarBandera(int [] valores){
        if(banderaMarcada){
            vista[valores[0]][valores[1]] = NO_VISTA;
            banderaMarcada = false;
        } else {
            vista[valores[0]][valores[1]] = VISTA_MARCAR_BANDERA;
            banderaMarcada = true;
        }
    }
}
