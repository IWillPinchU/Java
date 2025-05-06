import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        String filePath = "audio-club-amapiano-319840.wav";

        while (alarmTime == null) {
            try {
                System.out.println("Enter an alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Format.");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();

        System.out.println("Alarm set!");

        System.out.println("Press enter to stop Alarm!");
        scanner.nextLine();
        alarmClock.stopAlarm();
        System.out.println("Bye!");

        scanner.close();

    }
}
