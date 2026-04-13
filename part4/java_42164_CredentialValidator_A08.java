import java.security.InvalidParameterException;
import java.util.Base64;

public class java_42164_CredentialValidator_A08 {
    private static final String USERNAME = "dummy";
    private static final String PASSWORD = "dummy";

    public String validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidParameterException("Username and password cannot be empty");
        }

        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // If everything checks out, return a JWT here.
        return "Bearer " + Base64.getEncoder().encodeToString((USERNAME + ":" + PASSWORD).getBytes());
    }
}