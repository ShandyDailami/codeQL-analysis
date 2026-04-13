import java.util.Scanner;

public class java_06997_CredentialValidator_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        if (validateCredentials(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }

        scanner.close();
    }

    private static boolean validateCredentials(String username, String password) {
        // For the purpose of this example, we'll validate against a hardcoded string
        return username.equals("admin") && password.equals("password");
    }
}