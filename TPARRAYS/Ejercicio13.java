package TPARRAYS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio13 {
    final static int MAX = 5;
    public static void main(String[] args) {
        char[] characters = new char[MAX];
        setArray(characters);
        displayArray(characters);
        onlyVocals(characters);
        onlyConsonants(characters);
    }

    public static void setArray(char[] array) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int pos = 0; pos < MAX; pos++) {
                System.out.println("Ingrese el caracter de la posición " + pos + ": ");
                array[pos] = input.readLine().charAt(0);

            }
        } catch (Exception exc) {
            System.out.println(exc);

        }
        
    }

    public static void displayArray(char[] array) {
        for (int pos = 0; pos < MAX; pos++) {
            if(array[pos] != '\0') {
                System.out.println("array[" + pos + "] -> " + array[pos]);
            }
        }
    }

    public static void onlyVocals(char[] array) {
        char [] vocals = {'a', 'e', 'i','o', 'u'};
        char [] newArr = new char[array.length];
        int count = 0;
        for(int p = 0; p < vocals.length; p++) {
            for(int i = 0; i < array.length; i++) {
                if (vocals[p] == array[i]) {
                    newArr[count] = array[i];
                    count++;
                }
            }
        }
        System.out.println("Aqui estan solo las vocales");
        displayArray(newArr);
    }

    public static void onlyConsonants(char[] array) {
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        char [] newArr = new char[array.length];
        int count = 0;
        for(int p = 0; p < consonants.length; p++) {
            for(int i = 0; i < array.length; i++) {
                if (consonants[p] == array[i]) {
                    newArr[count] = array[i];
                    count++;
                }
            }
        }
        System.out.println("Aqui estan solo las consonantes");
        displayArray(newArr);
    }
}
