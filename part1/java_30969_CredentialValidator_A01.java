import java.util.Scanner;

public class java_30969_CredentialValidator_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        // hardcoded username and password for demonstration.
        // in a real application, these should be fetched from a database or another source.
        return "admin".equals(username) && "password".equals(password);
    }
}