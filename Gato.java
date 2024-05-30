package com.mycompany.gato;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Gato {

  static String[] tablita = new String[9];
    static String turno = "X";
    static int[][] winPositions = { 
        {0, 1, 2}, // Primera fila
        {3, 4, 5}, // Segunda fila
        {6, 7, 8}, // Tercera fila
        {0, 3, 6}, // Primera columna
        {1, 4, 7}, // Segunda columna
        {2, 5, 8}, // Tercera columna
        {0, 4, 8}, // Diagonal principal
        {2, 4, 6}  // Diagonal secundaria
    };

    public static void mostrarTablita() {
        System.out.println(
            tablita[0] + " | " + tablita[1] + " | " + tablita[2] + "\n" +
            "---------\n" +
            tablita[3] + " | " + tablita[4] + " | " + tablita[5] + "\n" +
            "---------\n" +
            tablita[6] + " | " + tablita[7] + " | " + tablita[8]
        );
    }

    public static String checkWinner() {
        for (int[] winPosition : winPositions) {
            String line = tablita[winPosition[0]] + tablita[winPosition[1]] + tablita[winPosition[2]];
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        
        for (int a = 0; a < 9; a++) {
            if (tablita[a].equals(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "Empate";
            }
        }
        System.out.println("Es el turno de la ficha: " + turno );
        return null;
    }
    
    public static void limpiarTabla(){
        for (int a = 0; a < 9; a++) {
            tablita[a] = String.valueOf(a + 1);
        }
    }

    
    public static void main(String[] args) {
      
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al tictactoe.");
      
        Boolean bandera = true;
        Jugar();
            do {
            
                System.out.println("¿Quiere volver a jugar?");    
                 System.out.println("1. Volver a jugar"); 
                 System.out.println("2. Salir"); 
            int res = leer.nextInt();
            switch (res){
                case 1: 
                     Jugar();
                 break;
                case 2:
                    bandera = false;
                  break;
                default: 
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (bandera);
        System.out.println("Juego finalizado");
   
    }
    
    public static void Jugar(){
        limpiarTabla();
        mostrarTablita();
        turno = "X";
        System.out.println("X es primer turno:");
        Scanner in = new Scanner(System.in); //Escaner para ir leyendo datos en consola
        String winner = null;
        while (winner == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Casilla no valida, intentalo de nuevo");
                    continue;
   
                }
            } catch (Exception e) {
                System.out.println("Solo valores numericos del 1 al 9:");
                continue;
            }
            if (tablita[numInput - 1].equals(String.valueOf(numInput))) { //Si la casilla sigue siendo un numero
                tablita[numInput - 1] = turno;//Remplaza el valor de la casilla
                turno = turno.equals("X") ? "O" : "X"; //Hacemos cambio de turno
                mostrarTablita(); //mostramos nuestra tablita uwu
                winner = checkWinner(); //verificamos si hay un ganador / empate
            } else {
                System.out.println("Esa casilla ya fue tomada, escoge otra.");
            }
        }
        
            if (winner.equalsIgnoreCase("Empate")) {
                System.out.println("Ha sido un empate, gracias por jugar.");
                
            
                } else {
                    System.out.println("¡ Felicidades la ficha" + winner + " has ganado!");
                }
                
        
    }
}
