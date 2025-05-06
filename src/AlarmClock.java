import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final String filePath;
    private Clip clip;


    AlarmClock(LocalTime alarmTime, String filePath){
        this.alarmTime = alarmTime;
        this.filePath = filePath;
    }

    public void stopAlarm(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            System.out.println("Alarm stopped.");
        }
    }

    @Override
    public void run(){
        while(LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);

                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d",now.getHour(), now.getMinute(),now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thread was Interrupted");
            }
        }

        File file = new File(filePath);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("\n*Alarm Noises*");
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(500);
            clip.start();
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Audio File is not supported!");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println("Something went wrong!");

        } catch (LineUnavailableException e) {
            System.out.println("Unable to Access Audio File!");

        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }
}
