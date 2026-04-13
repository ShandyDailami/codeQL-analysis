import java.util.Scanner;

public class java_33135_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}

class CredentialValidator {

    private String validUsername = "admin";
    private String validPassword = "password";

    public boolean validateCredentials(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }
}