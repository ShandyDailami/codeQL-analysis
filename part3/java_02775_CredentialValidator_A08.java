import java.security.InvalidParameterException;

public class java_02775_CredentialValidator_A08 implements CredentialValidator {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARS = "!@#$%^&*()";

    @Override
    public boolean validate(Credential credential) throws InvalidParameterException {
        String password = credential.getPassword();

        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }

        if (!containsSpecialChar(password)) {
            throw new InvalidParameterException("Password must contain at least one of the symbols $@#");
        }

        return true;
    }

    private boolean containsSpecialChar(String str) {
        for (char c : str.toCharArray()) {
            if (SPECIAL_CHARS.contains(c + "")) {
                return true;
            }
        }
        return false;
    }
}