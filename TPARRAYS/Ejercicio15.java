package TPARRAYS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio15 {
    final static int MAX = 10;
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int arr[] = { 1, 5, 7, 8, 9, 4, 3, 5, 2, 6};
            int pos = 0;
            displayArray(arr);
            System.out.println("Ingrese posicion inicial del corrimiento");
            pos = Integer.valueOf(input.readLine());
            bubbleRightPush(pos, arr);
            displayArray(arr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void displayArray(int[] numArr) {
            System.out.print("|");
            for (int i = 0; i < MAX; i++) {
                System.out.print(numArr[i] + "|");
            }
            System.err.println();
        }

        public static void bubbleRightPush(int pos, int[] arr) {
            int aux = 0;
            for(int i = MAX - 1; i > pos; i--) {
                aux = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = aux;
            }
        }
        
    }
