import java.security.InvalidParameterException;

public class java_06705_CredentialValidator_A07 {
    public static boolean validate(String username, String password) throws InvalidParameterException {
        // Check if username or password is null
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Check if username and password match the expected values
        if (!username.equals("admin") || !password.equals("admin")) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // If everything is fine, return true
        return true;
    }
}