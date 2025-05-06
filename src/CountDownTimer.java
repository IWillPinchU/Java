import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no of seconds to countdown from: ");
        int response = scanner.nextInt();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            int count = response;

            @Override
            public void run() {
                System.out.println(count);
                count--;
                if (count<=0){
                    System.out.println("Timer Escaped!");
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        scanner.close();
    }
}
