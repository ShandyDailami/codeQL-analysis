import java.security.InvalidParameterException;

public class java_36650_CredentialValidator_A08 {

    private static final String USERNAME_PATTERN = "^admin$";
    private static final String PASSWORD_PATTERN = "^admin$";

    public boolean validate(String username, String password) throws InvalidParameterException {
        if (!username.matches(USERNAME_PATTERN)) {
            throw new InvalidParameterException("Invalid username: " + username);
        }
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Invalid password: " + password);
        }
        return true;
    }
}