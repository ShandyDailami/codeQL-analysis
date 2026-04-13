import java.util.Scanner;

public class java_18355_CredentialValidator_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        if (!validateCredentials(username, password)) {
            System.out.println("Login failed!");
        } else {
            System.out.println("Login successful!");
        }

        scanner.close();
    }

    public static boolean validateCredentials(String username, String password) {
        // Simulating a security sensitive operation related to A07_AuthFailure
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}