import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

// Define the CredentialValidator interface
public interface CredentialValidator {
    Map<String, String> validate(String username, String password) throws InvalidParameterException;
}

// Implement the CredentialValidator interface
public class java_02300_CredentialValidator_A07 implements CredentialValidator {
    private static final String SUCCESS_MESSAGE = "Successfully authenticated";
    private static final String USERNAME_PATTERN = "[a-zA-Z0-9_]+";
    private static final String PASSWORD_PATTERN = "[a-zA-Z0-9_]{6,}";
    private Map<String, String> validationResults;

    public java_02300_CredentialValidator_A07() {
        this.validationResults = new HashMap<>();
    }

    @Override
    public Map<String, String> validate(String username, String password) throws InvalidParameterException {
        // Perform basic validation
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        if (!username.matches(USERNAME_PATTERN) || !password.matches(PASSWORD_PATTERN)) {
            throw new InvalidParameterException("Username must match the pattern [a-zA-Z0-9_] and password must match the pattern [a-zA-Z0-9_]{6,}");
        }

        // Add real authentication logic here
        // For this example, let's just check for a static success
        if (username.equals("validUser") && password.equals("validPassword")) {
            validationResults.put("AuthenticationStatus", SUCCESS_MESSAGE);
        } else {
            validationResults.put("AuthenticationStatus", "Failed");
        }

        return validationResults;
    }
}