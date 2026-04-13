import java.util.HashSet;
import java.util.Set;

public class java_35435_CredentialValidator_A03 {

    // Predefined list of acceptable passwords
    private static final Set<String> ALLOWED_PASSWORDS = new HashSet<>();

    static {
        ALLOWED_PASSWORDS.add("password1");
        ALLOWED_PASSWORDS.add("password2");
        ALLOWED_PASSWORDS.add("password3");
        // ... add more passwords as needed
    }

    // CredentialValidator interface requires a method to validate the password
    public static class PasswordValidator implements CredentialValidator {

        @Override
        public boolean validate(UsernamePasswordCredential credentials) {
            String password = credentials.getIdentifier();
            return ALLOWED_PASSWORDS.contains(password);
        }
    }

    // Entry point for the program
    public static void main(String[] args) {
        // Initialize the CredentialValidator
        CredentialValidator validator = new PasswordValidator();

        // Use the CredentialValidator...
        // ...
    }
}