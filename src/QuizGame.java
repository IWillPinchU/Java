import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] questions = {"A) What is the longest that an elephant has ever lived? (That we know of) ",
                "B) How many rings are on the Olympic flag?",
                "C) What is a tarsier?",
                "D) In darts, what's the most points you can score with a single throw?",
                "E) Which of these animals does NOT appear in the Chinese zodiac?"};

        String[][] options = {{"1. 17 years","2. 86 years","3. 49 years","4. 142 years"},
                {"1. None","2. 4","3. 5","4. 7"},
                {"1. Bird","2. Lizard","3. Primate","4. Fish"},
                {"1. 20","2. 50","3. 60","4. 100"},
                {"1. Bear","2. Dog","3. Dragon","4. Rabbit"}
        };

        int[] answers = {2,3,3,3,1};
        int score = 0;
        int guess;

        System.out.println("----------------------");
        System.out.println("Welcome to the QUIZ GAME!!!");
        System.out.println("----------------------");

        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            for(String option : options[i]){
                System.out.println(option);
            }
            System.out.println("----------------------");
            System.out.println("Enter your guess:");
            guess = scanner.nextInt();

            if (guess == answers[i]){
                System.out.println("Correct!");
                score++;
            }
            else{
                System.out.println("You are Wrong!");
            }
            System.out.println("----------------------");
        }
        System.out.printf("You Answered %d questions correctly out of %d!", score, questions.length);

        scanner.close();
    }

}
