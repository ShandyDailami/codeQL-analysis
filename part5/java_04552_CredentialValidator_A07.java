import java.util.Scanner;

public class java_04552_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.next();

        System.out.println("Please enter your password:");
        String password = scanner.next();

        if (validate(username, password)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static boolean validate(String username, String password) {
        // Simulate an authentication process by checking if the password is "correct"
        return password.equals("correct");
    }
}