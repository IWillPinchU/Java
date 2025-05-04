import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double temperature;
        double newTemperature;
        String unit;

        System.out.println("Enter the Temperature:");
        temperature = scanner.nextDouble();

        System.out.println("Convert to Celcius(C) or Fahrenheit(F): ");
        unit = scanner.next().toUpperCase();

        newTemperature = (unit.equals("C")) ? ( temperature - 32) * 5.0/9.0 : ( temperature * 9 / 5  ) + 32  ;

        System.out.printf("The Temperate is: % .2f°%s", newTemperature, unit); //u00B0

        scanner.close();
    }
}
