import java.util.Scanner;

public class java_11400_CredentialValidator_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (isValid(username, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    private static boolean isValid(String username, String password) {
        // Check if the password matches the pre-defined pattern (i.e., it contains at least one uppercase letter, one lowercase letter, one number, and one special character)
        // This is a very basic example of a credential validator. In a real-world application, you would likely use a more complex pattern.
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])");
    }
}