import java.util.Scanner;

public class java_27898_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String enteredPassword = scanner.next();

        if (isPasswordValid(enteredPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean isPasswordValid(String password) {
        // Hard-coded passwords for simplicity. In a real-world application,
        // these should be stored in a secure manner.
        return password.equals("securePassword");
    }
}