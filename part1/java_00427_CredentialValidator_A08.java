import java.security.InvalidParameterException;

public class java_00427_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]*$"; // Password must contain at least one letter and one number

    public boolean validate(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Password must contain at least one letter and one number");
        }

        return true;
    }
}