/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gatito;

import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Gatito {

  static Casilla[] tablita = new Casilla[9];
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
            tablita[0].getFicha() + " | " + tablita[1].getFicha() + " | " + tablita[2].getFicha() + "\n" +
            "---------\n" +
            tablita[3].getFicha() + " | " + tablita[4].getFicha() + " | " + tablita[5].getFicha() + "\n" +
            "---------\n" +
            tablita[6].getFicha() + " | " + tablita[7].getFicha() + " | " + tablita[8].getFicha()
        );
    }

    public static String checkGanador() {
        for (int[] winPosition : winPositions) {
            String line = tablita[winPosition[0]].getFicha() + tablita[winPosition[1]].getFicha() + tablita[winPosition[2]].getFicha();
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        
        for (int a = 0; a < 9; a++) {
            if (tablita[a].getFicha().equals(String.valueOf(a + 1))) {
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
            Casilla espacio = new Casilla();
            espacio.setFicha(String.valueOf(a + 1));
            tablita[a] = espacio;
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
        String ganador = null;
        while (ganador == null) {
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
            if (tablita[numInput - 1].getFicha().equals(String.valueOf(numInput))) { //Si la casilla sigue siendo un numero
                tablita[numInput - 1].setFicha(turno);//Remplaza el valor de la casilla
                turno = turno.equals("X") ? "O" : "X"; //Hacemos cambio de turno
                mostrarTablita(); //mostramos nuestra tablita uwu
                ganador = checkGanador(); //verificamos si hay un ganador / empate
            } else {
                System.out.println("Esa casilla ya fue tomada, escoge otra.");
            }
        }
        
            if (ganador.equalsIgnoreCase("Empate")) {
                System.out.println("Ha sido un empate, gracias por jugar.");
                
            
                } else {
                    System.out.println("¡ Felicidades la ficha " + ganador + " has ganado!");
                }
                
        
    }
    

    
}
