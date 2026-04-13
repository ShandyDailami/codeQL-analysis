import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

public class java_17543_CredentialValidator_A03 {

    // A static array of passwords for the sake of this example.
    // In a real-world application, you would likely want to use a secure method of storing and checking passwords.
    private static final String[] PASSWORDS = {"password1", "password2", "password3"};

    // A method to validate a password.
    public boolean validatePassword(String password) {
        // Simple base64 decode to check if password is not already in base64.
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        // If the password is not already in base64, decode it.
        if (!Arrays.asList(PASSWORDS).contains(decodedPassword)) {
            password = new String(Base64.getDecoder().decode(password));
        }

        // This is a very simple check for if a password is in our list of passwords.
        // You'd likely want to use a more secure way of checking passwords.
        return Arrays.asList(PASSWORDS).contains(password);
    }

    // A method to validate a username and password.
    public boolean validateCredentials(String username, String password) {
        return validatePassword(password) && validateUsername(username);
    }

    // A method to validate a username.
    public boolean validateUsername(String username) {
        // This is a very simple check for if a username is in our list of usernames.
        // You'd likely want to use a more secure way of checking usernames.
        return Arrays.asList(PASSWORDS).contains(username);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try a couple of credentials.
        System.out.println(validator.validateCredentials("alice", "password1")); // Should print: true
        System.out.println(validator.validateCredentials("bob", "password2")); // Should print: false
    }
}