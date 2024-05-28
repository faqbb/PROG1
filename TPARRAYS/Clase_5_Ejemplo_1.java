package TPARRAYS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase_5_Ejemplo_1 {
    final static int MAX = 5;

    public static void main(String[] args) {
        int[] enteros = new int[MAX];
        cargarArreglo(enteros);
        mostrarArreglo(enteros);
    }

    public static void cargarArreglo(int[] arrenteros) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            for (int pos = 0; pos < MAX; pos++) {
                System.out.println("Ingrese el entero de la posición " + pos + ": ");

                arrenteros[pos] = Integer.valueOf(entrada.readLine());

            }
        } catch (Exception exc) {
            System.out.println(exc);

        }
    }

    public static void mostrarArreglo(int[] arrenteros) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.println("arrenteros[" + pos + "] -> " + arrenteros[pos]);
        }
    }
}// fin del class