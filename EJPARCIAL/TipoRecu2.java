package EJPARCIAL;

public class TipoRecu2 {
    final static int MAX_COL = 23;
    final static int MAX_FILA = 3;

    public static void main(String[] args) {
        char[][] message = {
            {'-', 'S', 'u', 'p', 'e', 'r', ' ', 's', 'e', 'c', 'r', 'e', 't', 'o', ':', '-', '-', '-', '-', '-', '-', '-', '-','-', '-'},
            {'¡', '¡', 'n', 'o', ' ', 'c', 'o', 'r', 't', 'a', 'r', ' ', 'f', 'o', 'r', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ','c', 'o', 'n', ' ', 'r', 'e', 't', 'u', 'r', 'n', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', ' ', ' ', ' ', ' '}
        };

        for(int rowCount = 0; rowCount < MAX_FILA;  rowCount++) {
            int secStart = 0;
            int secEnd = -1;
            encryptRow(message[rowCount], secStart, secEnd);
            displayRow(message[rowCount]);
        }
    }

    public static void encryptRow(char[] row, int secStart, int secEnd) {
        int secLength = 0;
        while(secStart < MAX_COL) {
            secStart = findStart(row, secEnd + 1);
            if (secStart < MAX_COL) {
                secEnd = findEnd(row, secStart) ;
                secLength = secEnd - secStart +1 ;
                int i = secStart   ;
                while(i <= secEnd ){
                    if(!isVocal(row[i])) {
                        moveRightAndInsert(row, i , row[i]);
                        secEnd++;
                        i+=2;
                    } else if(isLetter(row[i])) {
                        row[i] = (char)(row[i] + secLength );
                        i++;
                    }
                }
            }
        }
        secEnd = secStart + secLength +1 ;       
    }

    
    public static int findStart(char[] row, int pos) { // encuentra ini
        while (pos < MAX_COL && !isLetter(row[pos])) {
            pos++;
        }
        return pos;
    }

    public static int findEnd(char[] row, int pos) { // encuentra fin
        while (pos < MAX_COL && isLetter(row[pos])) {
            pos++;
        }
        return pos -1;
    }

    public static void moveRightAndInsert(char[] row, int pos, char letter) {
        for(int i = MAX_COL -1; i > pos  ; i-- ) {
            row[i] = row[i-1];
        }
        row[pos] = letter;
    }


    public static boolean isLetter(char value) {
        if(value >= 'a' && value <= 'z' || value >= 'A' && value <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVocal (char letter) {
        char[] vocals = {'a', 'e', 'i', 'o', 'u'};
        boolean found = false;
        for(int i = 0; i < vocals.length; i++) {
            if(letter == vocals[i])  {
                found = true;
            }
        }
        return found;
    }


    public static void displayRow(char[] arr) { //muestra el arreglo
        for (int i = 0; i < MAX_COL; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
