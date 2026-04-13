import java.util.Scanner;

public class java_35386_CredentialValidator_A08 {

    // Set predefined password
    private static String predefinedPassword = "123456";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String userPassword = scanner.nextLine();

        if (isPasswordValid(userPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    // Method to check if the user password matches the predefined password
    private static boolean isPasswordValid(String userPassword) {
        return userPassword.equals(predefinedPassword);
    }
}