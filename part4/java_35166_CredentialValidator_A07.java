import java.security.InvalidParameterException;
import java.util.Base64;

public class java_35166_CredentialValidator_A07 {

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        String base64Password = Base64.getEncoder().encodeToString(password.getBytes());

        String encryptedPassword = "Basic " + base64Password;

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Encrypted Password: " + encryptedPassword);

        if (!validate(username, encryptedPassword)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        System.out.println("Access granted");
    }

    private static boolean validate(String username, String encryptedPassword) {
        // This is a dummy method that will be replaced by the real implementation
        // This method is not secure and should not be used in a real-world application

        // For testing purposes, this method always returns true
        return true;
    }
}