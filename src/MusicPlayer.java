import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {
        String filePath = "audio-club-amapiano-319840.wav";
        File file = new File(filePath);
        long clipTime = 0;

        try(Scanner scanner = new Scanner(System.in);AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            int response = 0;

            while(response != 6){

                System.out.println("------------------------");

                System.out.println("1. Play");
                System.out.println("2. Stop");
                System.out.println("3. Reset");
                System.out.println("4. Pause");
                System.out.println("5. Resume");
                System.out.println("6. Quit");

                System.out.println("------------------------");

                System.out.println("Enter your choice: ");
                response = scanner.nextInt();

                switch(response){
                    case 1 -> clip.start();
                    case 2 -> clip.stop();
                    case 3 -> clip.setMicrosecondPosition(0);
                    case 4 -> {
                        clipTime = clip.getMicrosecondPosition();
                        clip.stop();
                    }
                    case 5 -> {
                        clip.setMicrosecondPosition(clipTime);
                        clip.start();
                    }
                    case 6 -> clip.stop();
                    default -> System.out.println("Invalid Choice!");
                }
            }
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
        }
        finally{
            System.out.println("Bye!");
        }
    }
}
