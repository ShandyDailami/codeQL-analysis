import java.util.Base64;

public class java_04061_CredentialValidator_A03 {

    // Hardcoded passwords for simplicity
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Method to validate user credentials
    public static boolean validate(String enteredUsername, String enteredPassword) {
        return (USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword));
    }

    // Example of an injection vulnerability
    public static void main(String[] args) {
        String user = "user";
        String password = "password";
        String enteredUser = "user";
        String enteredPassword = "wrongPassword";

        System.out.println("Attempting to login with credentials: " + user + ", " + password);

        // Incorrect password
        if (validate(user, enteredPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}