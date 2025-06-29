import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num1;
        double num2;
        char operator;
        double result = 0;
        boolean validOperation = true;

        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Enter the operator (+, -, *, /, ^): ");
        operator = scanner.next().charAt(0);

        switch(operator){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if(num2 == 0){
                    System.out.println("Cannot Divide by zero!");
                    validOperation = false;
                }
                else {
                    result = num1 / num2;
                }
            }
            case '^' -> result = Math.pow( num1, num2);
            default -> {
                System.out.print("Invalid Operator");
                validOperation = false;
            }
        }

        if(validOperation){
            System.out.println(result);
        }
    }
}
