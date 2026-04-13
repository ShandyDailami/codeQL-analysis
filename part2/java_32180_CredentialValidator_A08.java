import java.util.Scanner;

public class java_32180_CredentialValidator_A08 {

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

        scanner.close();
    }

    private static boolean validateCredentials(String username, String password) {
        // This is a placeholder for the actual implementation. 
        // It's not actually security-sensitive, but it's a good practice to have a mechanism for it.
        // We'll just assume it's valid if the username is "admin" and the password is "password".
        return username.equals("admin") && password.equals("password");
    }
}