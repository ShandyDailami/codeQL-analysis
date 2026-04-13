import java.util.Scanner;

public class java_30806_CredentialValidator_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctPassword = "password"; // Change this to your actual password

        System.out.println("Enter password:");
        String userPassword = scanner.next();

        if (userPassword.equals(correctPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        scanner.close();
    }
}