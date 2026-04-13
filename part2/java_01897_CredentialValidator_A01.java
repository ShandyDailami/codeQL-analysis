import java.util.Scanner;

public class java_01897_CredentialValidator_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.next();
        System.out.println("Please enter your password:");
        String password = scanner.next();

        CredentialValidator validator = new CredentialValidator(username, password);
        boolean isValid = validator.validate();

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}

class CredentialValidator {
    private String username;
    private String password;

    public java_01897_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a dummy validate method that checks if the username and password are not null and if they are not empty
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // Here, we're just checking if the username is "admin" and the password is "password"
        // In a real-world application, you would likely want to hash the passwords and compare them in a secure way
        return username.equals("admin") && password.equals("password");
    }
}