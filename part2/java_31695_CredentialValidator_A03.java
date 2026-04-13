import java.util.Scanner;

public class java_31695_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        if (validateCredentials(username, password)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        // A simple validation. In a real-world application, you would likely want to use a more complex algorithm.
        // This is just a minimal example.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}