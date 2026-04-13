import java.util.Base64;

public class java_15720_CredentialValidator_A01 {

    // This is a simple username/password validation.
    // It's not secure for a real-world application.
    // In a real application, you would likely use a hashed password
    // and check against a hash of the entered password.
    public boolean validateCredentials(String username, String password) {
        String correctUsername = "admin";
        String correctPassword = "password";

        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    // This method is used for the purpose of demonstration.
    // It's not secure for a real-world application.
    // In a real application, you would likely use a hashed password
    // and check against a hash of the entered password.
    public String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}