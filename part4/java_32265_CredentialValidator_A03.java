import java.util.Arrays;
import java.util.List;

public class java_32265_CredentialValidator_A03 {

    // List of allowed usernames and passwords
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean isValid(String username, String password) {
        // Check if the username and password are in the allowed list
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            System.out.println("Credentials are valid!");
            return true;
        } else {
            System.out.println("Credentials are not valid!");
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        validator.isValid("user1", "password1");  // Should print: "Credentials are valid!"
        validator.isValid("user4", "password4");  // Should print: "Credentials are not valid!"
    }
}