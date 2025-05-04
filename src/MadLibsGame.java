import java.util.Scanner;

public class MadLibsGame {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String adjective1;
        String noun1;
        String adjective2;
        String verb1;
        String adjective3;

        System.out.println("Enter your adjective(descriptive):");
        adjective1 = scanner.nextLine();
        System.out.println("Enter your noun(item):");
        noun1 = scanner.nextLine();
        System.out.println("Enter your adjective(description):");
        adjective2 = scanner.nextLine();
        System.out.println("Enter your verb(action):");
        verb1 = scanner.nextLine();
        System.out.println("Enter your adjective(description):");
        adjective3 = scanner.nextLine();



        System.out.println("I went to a " + adjective1 + " museum");
        System.out.println("I Saw a beautiful " + noun1 + ".");
        System.out.println("The " + noun1 + " was" + adjective2 + " and " + verb1 + ".");
        System.out.println("I was " + adjective3 +"!");

        scanner.close();
    }
}
