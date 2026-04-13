import java.security.InvalidParameterException;

public class java_00384_CredentialValidator_A07 {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    public boolean isValid(String inputUsername, String inputPassword) {
        // Check if input is null
        if (inputUsername == null || inputPassword == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Compare input with predefined values
        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }
}