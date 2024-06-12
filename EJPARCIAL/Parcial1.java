package EJPARCIAL;
public class Parcial1 {
    final static int MAXP = 24;
    final static int MAXT = 2;
    final static int SEPARADOR = 0;
    public static void main(String[] args) {
        int[] arrP = {0 ,0 ,12 ,9 ,18, 0 ,2, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 2, 0, 0, 0, 0, 0, 0};
        int[] arrT = {4, 9};

        int R = 77;
        int C = 2;
        int cantC = 0;

        int iniP = 0;
        int finP = -1;

        mostrar(arrP);

        while (iniP < MAXP && cantC < C) {
            iniP = findIni(arrP, finP + 1);
            finP = findFin(arrP, iniP);
           if (findSec(arrP, iniP, arrT)) {
                insertProd(arrP, finP, R);
                iniP = finP+1;
                finP = findFin(arrP, iniP) + 1;
                cantC++;
                mostrar(arrP);
           }}
    }

    public static int findIni( int[] arrP , int pos) {
        while(pos < MAXP && arrP[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int findFin( int[] arrP , int pos) {
        while(pos < MAXP && arrP[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    public static void insertProd(int[] arr, int pos, int prod) {
        int aux = 0;
        for(int i = MAXP - 1; i > pos +1; i--) {
            aux = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = aux;
        }
        arr[pos + 1] = prod;
    }

    public static void mostrar(int[] arr) {
        for (int i = 0; i < MAXP; i++)
            System.out.print(arr[i] + " | ");
        System.out.println();
    }

    public static boolean findSec(int[] arrP, int pos, int[] arrT) {
        boolean found = false;
        int i = 0;
        while (found == false &&  i < MAXT) {
            for(int j = pos + 1; j < MAXP; j++) {
                if(arrP[j] == arrT[i]) {
                    found = true;
                }
            }
            i++;
        }
        return found;
        }
    }

