package EJPARCIAL;

public class Parcial3 {
        public final static int MAX = 21;
        public final static int SEPARADOR = -1;
    
        public static void main(String[] args) {
            int[] arrAcc = {-1,12,22,24,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,57,-1};
            int[] arrP =   {-1,-1,-1,-1,-1,-1,-1,-1,23,34,55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            int n = 2;
    
            int cantRepeticiones = 0;
            int cantOcurrencias = 0;
    
            int ini = 0;
            int fin = -1;
    
            // Tamanios?
            // Buscamos ini y fin al principio pq siempre está en la misma ubicacion y es una sola
            int iniP = buscarInicio(arrP, 0);
            int finP = buscarFin(arrP, iniP);
    
            mostrar(arrAcc);
    
            // Recorrer secuencia a secuencia el arrAcc
            while (ini < MAX) {
                // Buscar inicio
                ini = buscarInicio(arrAcc, fin + 1);
                if (ini < MAX) {
                    // Buscar fin
                    fin = buscarFin(arrAcc, ini);
                    // Aca tenemos una secuencia entre ini y fin
                    if (sonSecuenciasIguales(arrAcc, ini, fin, arrP, iniP, finP)) {
                        cantRepeticiones++;
                        if (cantRepeticiones > n) {
                            eliminarSecuencia(arrAcc, ini, fin);
                            fin = ini;
                        }
                        else {
                            if (cantRepeticiones == n)
                                cantOcurrencias++;
                        }
                    }
                    else {
                        cantRepeticiones = 0;
                    }
                }
            }
            mostrar(arrAcc);
            System.out.println("El patron se detecto " + cantOcurrencias + " veces.");
        }   
    
        public static void eliminarSecuencia(int[] arr, int ini, int fin) {
            for (int i = ini; i <= fin; i++)
                corrimientoAIzq(arr, ini);
        }
    
        public static void corrimientoAIzq(int[] arr, int pos) {
            for (int i = pos; i < MAX - 1; i++)
                arr[i] = arr[i + 1];
        }
    
        // Determinar si las dos secuencias son iguales
        public static boolean sonSecuenciasIguales(int[] arrA, int iniA, int finA, int[] arrP, int iniP, int finP) {
            int tamanioA = finA - iniA + 1;
            int tamanioP = finP - iniP + 1;
            if (tamanioA == tamanioP) {
                // Determinar si son iguales, elemento a elemento
                /*boolean sonIguales = true;
                while (iniA <= finA && sonIguales) {
                    if (arrA[iniA] != arrP[iniP])
                        sonIguales = false;
                    iniA++;
                    iniP++;
                }
                 return sonIguales;
                */
    
                while (iniA <= finA && arrA[iniA] == arrP[iniP]) {
                    iniA++;
                    iniP++;
                }
    
                /*if (iniA > finA)
                    return true;
                else
                    return false;
                */
                return iniA > finA;
    
               
            }
            else {
                return false;
            }
        }
    
        public static int buscarInicio(int[] arr, int pos) {
            while (pos < MAX && arr[pos] == SEPARADOR) {
                pos++;
            }
    
            return pos;
        }
    
        public static int buscarFin(int[] arr, int pos) {
            while (pos < MAX && arr[pos] != SEPARADOR)
                pos++;
            return pos - 1;
        }
    
        public static void mostrar(int[] arr) {
            for (int i = 0; i < MAX; i++)
                System.out.print(arr[i] + " | ");
            System.out.println();
        }
    }
