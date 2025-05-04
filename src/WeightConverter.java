import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double weight;
        double converted;
        int choice;

        System.out.println("Weight Conversion Program");
        System.out.println("1. Convert lbs to kgs");
        System.out.println("2. Convert Kgs to lbs");

        System.out.println("Choose an option:");
        choice = scanner.nextInt();

        if(choice == 1){
            System.out.println("Enter the weight in lbs: ");
            weight = scanner.nextDouble();
            converted = weight * 0.453592;
            System.out.printf("The Weight in Kgs is: %.3f", converted);
        }
        else if (choice == 2){
            System.out.println("Enter the weight in Kgs: ");
            weight = scanner.nextDouble();
            converted = weight * 2.20462;
            System.out.printf("The Weight in lbs is: %.3f", converted);
        }
        else{
            System.out.println("Invalid Choice!");
        }

        scanner.close();
    }
}
