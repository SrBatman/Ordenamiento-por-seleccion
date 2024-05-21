/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Proyecto {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        Alumno arr[] = new Alumno[5];
        System.out.println("Ingresa 5 alumnos con sus respectivas calificaciones al Sistema");
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingresa el nombre del alumno #" + (i+1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingresa la calificacion de " + nombre + ":");
            int calificacion = scanner.nextInt();
            scanner.nextLine(); 
            arr[i] = new Alumno(nombre, calificacion);
        }

        sort(arr);
        System.out.println("Lista de alumnos ordenada por calificacion del mas bajo al mas alto:");
        printArray(arr);
        System.out.println("El más bajo fue: " + arr[0].nombre + " con un resultado de: " + arr[0].calificacion + " :(");
        System.out.println("El más alto fue: " + arr[arr.length-1].nombre + " con un resultado de: " + arr[arr.length-1].calificacion + " :0");
    }
    
    static void sort(Alumno arr[]) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j].calificacion < arr[min_idx].calificacion)
                    min_idx = j;

            Alumno temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Imprime el arreglo
    public static void printArray(Alumno arr[]) {
              int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i].nombre + ": " + arr[i].calificacion);
        System.out.println();
    }
    
 public static class Alumno {
    String nombre;
    int calificacion;

    // Constructor
    public Alumno(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
}



}
