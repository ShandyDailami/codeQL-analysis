import java.util.regex.Pattern;

public class java_32917_CredentialValidator_A08 {

    // Pattern for a username that starts with "admin"
    private static final Pattern ADMIN_PATTERN = Pattern.compile("^admin\\w*$");

    // Throw an exception if the username doesn't match the pattern
    public void validate(String username) {
        if (!ADMIN_PATTERN.matcher(username).matches()) {
            throw new A08_IntegrityFailure("Username must start with 'admin'");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin");
        validator.validate("adminTest");
    }
}

class A08_IntegrityFailure extends RuntimeException {
    public java_32917_CredentialValidator_A08(String message) {
        super(message);
    }
}