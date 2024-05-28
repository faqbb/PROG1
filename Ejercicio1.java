import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        int number = 0;
        try {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserte numero");
        number = Integer.valueOf(input.readLine());
        while (verifyInput(number)) {
            System.out.println("Inserte numero");
            number = Integer.valueOf(input.readLine());
        }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean verifyInput(int input) {
        if(input == 0) {
            return false;
        } else {
            return true;
        }
    }
}
