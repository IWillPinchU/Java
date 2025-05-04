import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        String[] choices = {"ROCK🪨","PAPER📄","SCISSORS✂️"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";
        int playerScore = 0;
        int computerScore = 0;

        do{
            System.out.println("Enter your move (ROCK, PAPER, SCISSORS): ");
            playerChoice = scanner.nextLine().toUpperCase();

            if(!playerChoice.equals("ROCK") &&
                    !playerChoice.equals("PAPER") &&
                    !playerChoice.equals("SCISSORS"))
            {
                System.out.println("INVALID CHOICE!");
                continue;
            }

            computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer choice: " + computerChoice);

            if (computerChoice.contains(playerChoice)){
                System.out.println("IT'S A TIE!");
                playerScore++;
                computerScore++;
            }
            else if (
                    (playerChoice.equals("ROCK") && computerChoice.contains("SCISSORS")) ||
                            (playerChoice.equals("PAPER") && computerChoice.contains("ROCK")) ||
                            (playerChoice.equals("SCISSORS") && computerChoice.contains("PAPER")))
            {
                System.out.println("YOU WIN!");
                playerScore++;
            }
            else {
                System.out.println("YOU LOSE!");
                computerScore++;
            }

            System.out.println("-----------------");
            System.out.println("Play Again?");
            playAgain = scanner.nextLine().toLowerCase();
            System.out.println("-----------------");
        }while(playAgain.equals("yes"));

        System.out.printf("Your Win-lose Score is %d-%d\n", playerScore, computerScore);
        System.out.println("THANKS FOR PLAYING!!!!");
        System.out.println("-----------------");

        scanner.close();
    }
}
