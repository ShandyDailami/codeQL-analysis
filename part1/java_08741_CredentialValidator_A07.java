import java.security.InvalidParameterException;

public class java_08741_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

    private String validUsername;
    private String validPassword;

    public java_08741_CredentialValidator_A07(String validUsername, String validPassword) {
        if (validUsername == null || validUsername.length() == 0) {
            throw new InvalidParameterException("Username is required");
        }
        if (validPassword == null || validPassword.length() == 0) {
            throw new InvalidParameterException("Password is required");
        }
        if (!validUsername.matches(USERNAME_PATTERN)) {
            throw new InvalidParameterException("Username must contain only letters and numbers");
        }
        if (!validPassword.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Password must contain only letters and numbers");
        }
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    @Override
    public boolean validate(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }
}