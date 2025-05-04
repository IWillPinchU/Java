import java.util.Scanner;

public class BankingProgram {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double balance = 0;
        int choice;

        boolean isRunning = true;

        while(isRunning) {

            choice = choiceUser();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                    balance += deposit();
                    showBalance(balance);
                }
                case 3 -> {
                    balance -= withdraw(balance);
                    showBalance(balance);
                }
                case 4 -> {
                    isRunning = false;
                    exitProgram();
                }
                default -> System.out.println("Invalid Choice!\nPlease Enter a Valid Choice!");
            }
        }
    }

    static void showBalance(double balance){
        System.out.println("-----------------");
        System.out.printf("Your Current Balance is: ₹%,.2f\n", balance); //u20B9
    }
    static double deposit(){

        double amount;

        System.out.println("-----------------");
        System.out.println("Enter amount to be deposited:");
        amount = scanner.nextDouble();

        System.out.println("-----------------");
        if (amount<0){
            System.out.println("Amount can not be negative!");
            return 0;
        }
        else{
            System.out.println("Amount Deposited: ₹" + amount);
            return amount;
        }
    }
    static double withdraw(double balance){
        double amount;

        System.out.println("-----------------");
        System.out.println("Enter amount to be withdrawn:");
        amount = scanner.nextDouble();

        System.out.println("-----------------");
        if (amount<0){
            System.out.println("Amount can not be negative!");
            return 0;
        }
        else if (amount > balance){
            System.out.println("Insufficient Funds");
            return 0;
        }
        else{
            System.out.println("Amount Withdrawn: " + amount);
            return amount;
        }
    }
    static int choiceUser(){
        System.out.println("-----------------");
        System.out.println("BANKING PROGRAM");
        System.out.println("1. Current Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("-----------------");

        System.out.println("Enter your choice: ");
        return scanner.nextInt();
    }
    static void exitProgram(){
        System.out.println("-----------------");
        System.out.println("Exiting Program!");
        System.out.println("-----------------");
        System.out.println("Program Exited Successfully!");
        System.out.println("-----------------");
    }
}
