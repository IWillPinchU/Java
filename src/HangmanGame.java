import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args){

        String filePath = "HangmanWords.txt";
        ArrayList<String> words= new ArrayList<>();
        Random random = new Random();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                words.add(line.toUpperCase());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        catch(IOException e){
            System.out.println("Something went wrong!");
        }

        String word = words.get(random.nextInt(words.size()));
        System.out.println(word);

        char guess;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }
        System.out.println("--------------------------");
        System.out.println("WELCOME TO HANGMAN GAME");
        System.out.println("--------------------------");

        while(wrongGuesses < 6){
            System.out.print("Word: ");
            for(char c : wordState){
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Guess a letter: ");
            guess = scanner.next().toUpperCase().charAt(0);

            if(word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!");
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == guess){
                    wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')){
                    System.out.println("--------------------------");
                    System.out.println(getHangmanArt(7));
                    System.out.println("YOU WIN!");
                    System.out.printf("You guessed wrong %d times\n",wrongGuesses);
                    System.out.println("The word was " + word);
                    System.out.println("--------------------------");
                    break;
                }
            }
            else{
                wrongGuesses++;
                System.out.println("Wrong Guess!");
                if (wrongGuesses <= 5) {
                    System.out.println("--------------------------");
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("--------------------------");
                }
            }
            System.out.println();
        }

        if(wrongGuesses == 6){
            System.out.println("--------------------------");
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!!!");
            System.out.println("The word was " + word);
            System.out.println("--------------------------");
        }
        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses){
        return switch(wrongGuesses){
            case 0 -> """
                    
                    
                    
                      """;
            case 1 -> """
                       |
                       |
                       O
                    
                    
                      """;
            case 2 -> """
                       |
                       |
                       O
                       |
                    
                      """;
            case 3 -> """
                       |
                       |
                       O
                      /|
                    
                      """;
            case 4 -> """ 
                       |
                       |
                       O
                      /|\\
                    
                      """;
            case 5 -> """
                       |
                       |
                       O
                      /|\\
                      /
                      """;
            case 6 -> """
                       |
                       |
                       O
                      /|\\
                      / \\
                      """;
            case 7 -> """
                       O
                      \\|/
                      / \\
                     """;
            default -> "";
        };
    }
}
