import java.util.Optional;

public interface Credential {
    Optional<String> getUsername();
    Optional<String> getPassword();
}

public interface CredentialValidator {
    boolean isValid(Credential credential);
}

public class java_04685_CredentialValidator_A07 implements CredentialValidator {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    @Override
    public boolean isValid(Credential credential) {
        return isValidUsername(credential) && isValidPassword(credential);
    }

    private boolean isValidUsername(Credential credential) {
        return credential.getUsername().orElse("").equals(VALID_USERNAME);
    }

    private boolean isValidPassword(Credential credential) {
        return credential.getPassword().orElse("").equals(VALID_PASSWORD);
    }
}

public class CredentialAuthFailureException extends Exception {
    public java_04685_CredentialValidator_A07(String message) {
        super(message);
    }
}

public class CredentialAuthenticationService {
    private final CredentialValidator validator;

    public java_04685_CredentialValidator_A07(CredentialValidator validator) {
        this.validator = validator;
    }

    public void authenticate(Credential credential) throws CredentialAuthFailureException {
        if (!validator.isValid(credential)) {
            throw new CredentialAuthFailureException("Invalid username or password");
        }
    }
}