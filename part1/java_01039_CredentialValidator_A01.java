import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_01039_CredentialValidator_A01 {

    // List of allowed usernames and passwords
    private static final Set<String> ALLOWED_USERNAMES = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> ALLOWED_PASSWORDS = new HashSet<>(Arrays.asList("password1", "password2", "password3"));

    // CredentialValidator interface
    interface CredentialValidator {
        boolean validate(String username, String password);
    }

    // LegacyCredentialValidator class
    public static class LegacyCredentialValidator implements CredentialValidator {
        @Override
        public boolean validate(String username, String password) {
            return ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password);
        }
    }

    public static void main(String[] args) {
        // Instantiate the LegacyCredentialValidator
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        // Test with some credentials
        System.out.println(validator.validate("user1", "password1")); // Should print: true
        System.out.println(validator.validate("user4", "password1")); // Should print: false
    }
}