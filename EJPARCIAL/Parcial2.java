package EJPARCIAL;

public class Parcial2 {
    final static int MAXS = 17;
    final static int MAXA = 14;
    final static char SEPARADOR = ' ';
    public static void main(String[] args) {
        char[] S = {' ', 'L','A',' ','C','A','S', 'A',' ', 'E','N', ' ','A', 'L','T', 'O', ' '};
        char[] A = {' ', 'L','A', ' ','E', 'N',' ', 'D','E', ' ','D','E','L', ' '};
        int iniS = 0;
        int iniA = 0;
        int finS = -1;
        int finA = -1;


        display(S, MAXS);

        while (iniA < MAXA || iniS < MAXS ) {
            iniS = findIni(S, finS + 1, MAXS);
            finS = findFin(S, iniS, MAXS);
            iniA = findIni(A, finA + 1, MAXA);
            finA = findFin(A, iniA, MAXA);
            if(findSameSeq(S, iniS, finS, A, iniA, finA)) {
                deleteSeq(S, iniS, finS);
            }
            display(S, MAXS);

        }
    }

    public static int findIni(char[] arr, int pos, int Max) {
        while (pos < Max && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }
    public static int findFin(char[] arr, int pos, int Max) {
        while (pos < Max && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    public static boolean findSameSeq(char[] arrS, int iniS, int finS,char[] arrA, int iniA, int finA) {
        int tamanioS = finS - iniS  + 1;
        int tamanioA = finA - iniA + 1;
        if (tamanioA == tamanioS) {
            return true;
        } else { 
            return false;
        }
       }

    public static void deleteSeq(char[] arr, int ini, int fin) {
        for(int i = ini; i <= fin; i++) {
            arr[i] = ' ';
        }
    }

    public static void display(char[] arr, int MAX) {
        for (int i = 0; i < MAX; i++)
            System.out.print(arr[i] + " | ");
        System.out.println();
    }
}
