import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        String email;
        String username;
        String domain;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        if (email.contains("@")){
            username = email.substring(0, email.indexOf("@"));
            domain = email.substring(email.indexOf("@") + 1);

            System.out.println(username);
            System.out.println(domain);

        }

        scanner.close();
    }
}
