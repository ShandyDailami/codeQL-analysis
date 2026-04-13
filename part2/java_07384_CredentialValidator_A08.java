import java.security.InvalidParameterException;
import java.util.Base64;

public class java_07384_CredentialValidator_A08 {

    // Method to validate username and password
    public boolean validate(String user, String password) {
        // Convert to bytes
        byte[] userBytes = user.getBytes();
        byte[] passwordBytes = password.getBytes();

        // Encode user and password to Base64
        String encodedUser = Base64.getEncoder().encodeToString(userBytes);
        String encodedPassword = Base64.getEncoder().encodeToString(passwordBytes);

        // Validate user and password
        if (encodedUser.equals(encodedPassword)) {
            return true;
        } else {
            throw new InvalidParameterException("Username or password is incorrect");
        }
    }

    // Test
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String correctUser = "admin";
        String correctPassword = "password";

        try {
            validator.validate(correctUser, correctPassword);
            System.out.println("Validated successfully");
        } catch (InvalidParameterException e) {
            System.out.println("Error validating: " + e.getMessage());
        }

        String incorrectUser = "user";
        String incorrectPassword = "wrongpassword";

        try {
            validator.validate(incorrectUser, incorrectPassword);
        } catch (InvalidParameterException e) {
            System.out.println("Error validating: " + e.getMessage());
        }
    }
}