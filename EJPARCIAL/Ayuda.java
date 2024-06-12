package PROG1.TP5;

public class ayuda {
    public final static int MAX = 21;
    public final static int SEPARATOR = -1;
    public final static int R=200;

    public static void main(String[] args) {
        int[] arreglo = { -1, 12, 22, 24, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 55, -1, 23, 34, 57, -1 };
        int pos_I = 0;
        int pos_F = -1;
        Mostrar(arreglo);
        pos_I = Buscar_PosI(arreglo, pos_F + 1);
        pos_F = Buscar_PosF(arreglo, pos_I);
        agregarSecuencia(arreglo,pos_I,pos_F);
        eliminarSecuencia(arreglo,pos_I,pos_F);

        System.out.println("-----------------------------------------");
        System.out.println("pos_i: " + pos_I);
        System.out.println("pos_f: " + pos_F);
    }

    public static int Buscar_PosI(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == SEPARATOR) {
            pos++;
        }
        return pos;
    }

    public static int Buscar_PosF(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != SEPARATOR) {
            pos++;
        }
        return pos - 1;
    }

    public static void agregarSecuencia(int[] arr, int ini, int fin) {
        for (int v = MAX - 1; v > ini; v--) {
            arr[v] = arr[v - 1];
        }
        arr[ini] = R;
    }

    public static void eliminarSecuencia(int[] arr, int ini, int fin) {
        for (int p = ini; p <= fin; p++) {
            for (int v = ini; v < MAX - 1; v++) {
                arr[v] = arr[v + 1];
            }
        }
    }

    public static void Mostrar(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println("");
    }
}