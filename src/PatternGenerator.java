import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;
        char symbol;

        System.out.println("Enter the no of rows: ");
        rows = scanner.nextInt();

        System.out.println("Enter the no of columns: ");
        columns = scanner.nextInt();

        System.out.println("Enter the symbol you want: ");
        symbol = scanner.next().charAt(0);

        for(int i =0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
