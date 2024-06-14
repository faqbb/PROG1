package EJPARCIAL;

public class TipoRecu {
    final static int MAX_FILA = 3;
    final static int MAX_COL = 20;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[][] pic = {
            {0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -2, 17, 0, -4, 66, 0, -4, 90, 0, 0, 50, 0, 99, 0, 0, 0, 0, 0, 0, 0},
            {0, -5, 22, 0, -4, 3, 0, -2, 12, 0, 4, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0},
        };
        getMaxCompressionValues(pic);
    }

    public static void getMaxCompressionValues(int[][] mat) {
        int maxCompressionRow = 0;
        int maxCompression = 0;

        for (int cantFila = 0; cantFila < MAX_FILA; cantFila++) {
            int compressionCount = compressRow(mat[cantFila]);
            if (compressionCount > maxCompression) {
                maxCompression = compressionCount;
                maxCompressionRow = cantFila;
            }
            System.out.println("La cantidad de pixeles descomprimidos en esta fila fue de " + compressionCount);
        }

        System.out.println("La fila que descomprimió más pixeles fue la fila " + maxCompressionRow);
    }

    public static int compressRow(int[] row) {
        int ini = 0;
        int fin = -1;
        int compressionCount = 0;

        while (ini < MAX_COL) {
            ini = findIni(row, fin + 1);
            if (ini < MAX_COL) {
                fin = findFin(row, ini);
                if (row[ini] < 0) {
                    int cantReps = Math.abs(row[ini]) - 1;
                    compressionCount += cantReps+1 ;
                    int pixelValue = row[ini + 1];
                    moveInReps(row, fin + 1, cantReps);
                    replacePixel(row, ini, cantReps, pixelValue);
                    fin = ini + cantReps;
                }
            }
        }

        display(row);
        return compressionCount ;
    }


    public static int findIni(int[] row, int pos) { // encuentra ini
        while (pos < MAX_COL && row[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int findFin(int[] row, int pos) { // encuentra fin
        while (pos < MAX_COL && row[pos] != SEPARADOR) {
            pos++;
        }
        return pos -1;
    }

    public static void moveRight(int[] row, int pos) { //corre hacia la derecha
            for (int i = MAX_COL; i >= pos; i--) {
                row[i] = row[i - 1];
            }
        }

    public static void moveInReps(int[] row, int pos,  int cantReps) { //corre unas cantReps veces
        for(int i = 0; i < cantReps -1; i++) {
            moveRight(row, pos);
        }
    }


    public static void replacePixel(int[] row, int ini, int cantReps, int pixel) { //reemplaza cada valor de una parte delimitada de el arreglo por un valor pixel 
        for (int i = 0; i < cantReps ; i++) {
            row[ini + i ] = pixel;
        }
    }

    public static void display(int[] row) { //muestra el arreglo
        for (int i = 0; i < MAX_COL; i++) {
            System.out.print(row[i] + "|");
        }
        System.out.println();
    }
}
