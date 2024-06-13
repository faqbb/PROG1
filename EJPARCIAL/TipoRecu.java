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
        int maxCompressionRow = 0;
        int maxCompression = -1;
        
        for (int cantFila = 0; cantFila < MAX_FILA; cantFila++) { // el for que recorre las distintas filas de la matriz
            int ini = 0; 
            int fin = -1;
            int compressionCount = 0;
            while (ini < MAX_COL) {     // mientras ini no sea mayor al tamaño de la fila o arr.length
                ini = findIni(pic[cantFila], fin + 1);   // buscamos secuencia a partir de la posicion siguiente de la ultima secuencia o, en primera instancia, la primera posicion cuyo valor es distinto de SEPARADOR
                if (ini < MAX_COL) {    // verificamos que no nos hayamos salido del rango al redefinir ini
                    fin = findFin(pic[cantFila], ini) ;     // buscamos el final de la secuencia 
                    if (pic[cantFila][ini] < 0) {   // las secuencias que nos interesan empiezan con un numero en negativo, si cumple, encontramos una
                        int cantReps = Math.abs(pic[cantFila][ini]) - 1;    // ese valor negativo sera la cantidad de veces que tengamos que imprimir el pixel, le restamos 1 porque incluye el primero 
                        compressionCount += cantReps;
                        int pixelValue = pic[cantFila][ini + 1];    // define el valor del pixel para el reemplazo
                        moveInReps(pic[cantFila], fin + 1, cantReps);   // inicia desde una posicion despues de la secuencia y lo repite la cantidad señalada 
                        replacePixel(pic[cantFila], ini, cantReps , pixelValue);    // inicia desde que inicia la secuencia y lo repite la cantidad señalada 
                        fin = ini + cantReps ;  //redefinimos porque agrandamos la secuencia unos cantReps lugares
                    }
                }
            }
            if(maxCompression < compressionCount) {
                maxCompression = compressionCount;
                maxCompressionRow = cantFila;
            }
            display(pic[cantFila]);
            System.out.println("La cantidad de pixeles descomprimidos esta fila fue de " + compressionCount);
        }
        System.out.println("La fila que descomprimio mas pixeles fue la fila " + maxCompressionRow);
    }

    public static int findIni(int[] mat, int pos) { // encuentra ini
        while (pos < MAX_COL && mat[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int findFin(int[] mat, int pos) { // encuentra fin
        while (pos < MAX_COL && mat[pos] != SEPARADOR) {
            pos++;
        }
        return pos -1;
    }

    public static void moveRight(int[] mat, int pos) { //corre hacia la derecha
            for (int i = MAX_COL; i >= pos; i--) {
                mat[i] = mat[i - 1];
            }
        }

    public static void moveInReps(int[] mat, int pos,  int cantReps) { //corre unas cantReps veces
        for(int i = 0; i < cantReps -1; i++) {
            moveRight(mat, pos);
        }
    }


    public static void replacePixel(int[] mat, int ini, int cantReps, int pixel) { //reemplaza cada valor de una parte delimitada de el arreglo por un valor pixel 
        for (int i = 0; i < cantReps ; i++) {
            mat[ini + i ] = pixel;
        }
    }

    public static void display(int[] arr) { //muestra el arreglo
        for (int i = 0; i < MAX_COL; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
