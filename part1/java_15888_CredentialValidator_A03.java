import java.util.Base64;

public class java_15888_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Convert the provided credentials to bytes
        byte[] usernameBytes = username.getBytes();
        byte[] passwordBytes = password.getBytes();

        // Encode the username and password bytes
        String encodedUsername = Base64.getEncoder().encodeToString(usernameBytes);
        String encodedPassword = Base64.getEncoder().encodeToString(passwordBytes);

        // Validate the username and password
        return expectedUsername.equals(encodedUsername) && expectedPassword.equals(encodedPassword);
    }

    public static void main(String[] args) {
        // Validate the credentials
        boolean isValid = validate("admin", "password");

        // Print the result
        System.out.println("Is Valid: " + isValid);
    }
}