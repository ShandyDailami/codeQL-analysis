import java.security.InvalidParameterException;

public class java_28493_CredentialValidator_A08 {

    private String expectedUsername;
    private String expectedPassword;

    public java_28493_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        if (expectedUsername == null || expectedUsername.isEmpty() || expectedPassword == null || expectedPassword.isEmpty()) {
            throw new InvalidParameterException("Username and password cannot be null or empty");
        }
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidParameterException("Username and password cannot be null or empty");
        }
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }
}