public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_41304_CredentialValidator_A03 {
    private final CredentialValidator validator;

    public java_41304_CredentialValidator_A03(CredentialValidator validator) {
        this.validator = validator;
    }

    public boolean authenticate(String username, String password) {
        if (validator.validate(username, password)) {
            // Authentication successful.
            return true;
        } else {
            // Authentication failed.
            return false;
        }
    }
}

public class UserCredentialValidator implements CredentialValidator {
    private static final String KNOWN_USERNAME = "admin";
    private static final String KNOWN_PASSWORD = "password";

    @Override
    public boolean validate(String username, String password) {
        return username.equals(KNOWN_USERNAME) && password.equals(KNOWN_PASSWORD);
    }
}