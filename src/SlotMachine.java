import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int balance;
        int amount;
        int bet;
        int payout;
        char choice;
        String add;
        String[] row;
        String[] symbols = {"⭐","🍒", "🍕","🔔","🫃"};
        boolean isFirstTurn = true;

        System.out.println("-----------------------------------------");
        System.out.println("WELCOME TO SLOTS!");
        System.out.println("-----------------------------------------");

        do {
            System.out.println("How much money would you like to Add? (must be positive): ");
            balance = scanner.nextInt();
            if (balance < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } while (balance < 0);

        System.out.println("-----------------------------------------");
        System.out.println("Symbols: ⭐ 🍒 🍕 🔔 🫃");

        while(balance >= 0){
            if (!isFirstTurn) {
                System.out.println("-----------------------------------------");
                System.out.println("Do you want to continue playing? (yes/no): ");
                String continuePlaying = scanner.nextLine().trim().toLowerCase();
                if (continuePlaying.equals("no")) {
                    payout = balance;
                    System.out.println("-----------------------------------------");
                    System.out.println("Your Payout is: ₹" + payout);
                    System.out.println("THANK YOU FOR PLAYING!!!");
                    System.out.println("-----------------------------------------");
                    break;
                }
            }

            isFirstTurn = false;

            System.out.println("-----------------------------------------");
            System.out.println("Current Balance is: ₹" + balance);
            System.out.println("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if(bet > balance) {
                System.out.println("-----------------------------------------");
                System.out.println("INSUFFICIENT FUNDS");
                System.out.println("Do you want to add more money?(yes/no): ");
                add = scanner.nextLine().toLowerCase();
                if (add.equals("yes")) {
                    do {
                        System.out.println("Amount to add (must be positive): ");
                        amount = scanner.nextInt();
                        scanner.nextLine();
                        if (amount < 0) {
                            System.out.println("Invalid amount. Please enter a positive value.");
                        }
                    } while (amount < 0);
                    balance += amount;
                    System.out.println("Balance Updated Successfully!");
                }
                continue;
            }
            else if (bet <= 0){
                System.out.println("Bet must be greater than 0");
                continue;
                }

            System.out.println("-----------------------------------------");
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(symbols[random.nextInt(3)] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------------------");

            System.out.println("Would you like to spin?(Y/N): ");
            choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();

            if (choice == 'Y'){
                System.out.println("Spinning....");
                row = spinRow();
                if (row[0].equals(row[1]) && row[1].equals(row[2])){
                    balance += bet;
                    payout = balance;
                    System.out.println("Congratulations! YOU WIN!");
                    System.out.println("Your current payout is: ₹" + payout);
                }
                else{
                    balance -= bet;
                    payout = balance;
                    System.out.println("OH NO! YOU LOST!");
                    System.out.println("Your current payout is: ₹" + payout);
                }
            }
            else{
                payout = balance;
                System.out.println("-----------------------------------------");
                System.out.println("Your Payout is: ₹" + payout);
                System.out.println("THANKYOU FOR PLAYING!!!");
                System.out.println("-----------------------------------------");
                break;
            }
        }

        scanner.close();
    }
    static String[] spinRow(){

        Random random = new Random();

        String[] symbols = {"⭐","🍒", "🍕","🔔","🫃"};
        String[] row = new String[3];

        System.out.println("-----------------------------------------");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                String spinSymbol = symbols[random.nextInt(5)];
                System.out.print(spinSymbol+ " ");
                if (i==1){
                    row[j] = spinSymbol;
                }
            }
            System.out.println();
        }
        return row;
    }
}
