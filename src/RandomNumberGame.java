import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess;
        int attempts = 0;
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(min, max + 1);

        System.out.println("Number Guessing Game");
        System.out.printf("Guess a number between %d-%d\n",min,max);

        do{
            System.out.print("Enter a guess:");
            guess = scanner.nextInt();
            attempts++;

            if(guess < randomNumber){
                System.out.println("Your Number is too low!");
            }
            else if(guess>randomNumber){
                System.out.println("Your Number is too high!");
            }
            else{
                System.out.println("Correct! The Number was " + randomNumber);
                System.out.println("Number of attempts required: " + attempts);
            }
        } while(guess != randomNumber);

        scanner.close();

    }
}
