package com.mycompany.proyecto;

/**
 *
 * @author Asus
 */
public class Proyecto {

    public static void main(String[] args) {
         int arr[] = {12,60,40,7,22,55,1}; //Tamaño 7
        sort(arr);
        System.out.println("Resultado final: ");
        printArray(arr);
    }
    
    public static void sort(int arr[]) {
        int n = arr.length; //7

        // Recorre todos los elementos del arreglo
        for (int i = 0; i < n-1; i++) { //7-1
            
            int min_idx = i; // Encuentra el mínimo elemento en el arreglo sin ordenar
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) //Si el elemento actual del arreglado es menor que el minimo actual declarado anteriormente
                    min_idx = j; //Se declara un nuevo minimo elemento en el arreglo

            // Intercambia el mínimo elemento encontrado con el primer elemento
            int temp = arr[min_idx]; // Guarda el mínimo
            arr[min_idx] = arr[i];// Coloca el primer elemento en la posición del mínimo
            arr[i] = temp; // Coloca el mínimo en su lugar correcto
            printArray(arr); //va imprimiendo el arreglo para ir mostrando las rondas
        }
    }

    // Imprime el arreglo
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


}
