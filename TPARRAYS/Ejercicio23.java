package TPARRAYS;

public class Ejercicio23 {
    final static int MAX = 20;
    public static void main(String[] args) {
        try {
            int arr[] = { 0, 1, 2, 3, 0, 0, 0, 5, 2, 6, 0, 0, 1, 2, 0, 0, 0, 0, 1, 0};
            displayArray(arr);
            firstSequencePOS(arr);
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

    public static void firstSequencePOS(int[] arr) {
            int init = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            for(int i = 0; i < MAX - 1; i++) {
                if(init > MAX - 1 && arr[i] == 0) {
                    init = i;
                } else if (end < 0 &&   arr[i] == 0) {
                    end = i;
                    break;
                }                
            }
            System.out.println("INICIO: " + init + " FINAL: " + end);
        }
}
