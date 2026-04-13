import java.security.InvalidParameterException;

public class java_21705_CredentialValidator_A03 implements CredentialValidator {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String ALLOWED_STRING = "password";

    @Override
    public boolean authenticate(String username, String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password length must be at least " + MIN_PASSWORD_LENGTH);
        }

        if (!password.contains(ALLOWED_STRING)) {
            throw new InvalidParameterException("Password must contain the string 'password'");
        }

        return true;
    }
}