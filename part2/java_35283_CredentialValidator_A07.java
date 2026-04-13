import java.util.Scanner;

public class java_35283_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        String correctUsername = "admin";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }
}