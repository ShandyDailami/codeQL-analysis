import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class java_27142_CredentialValidator_A01 {

    private Set<String> validUsernames = new HashSet<>();

    public java_27142_CredentialValidator_A01() {
        validUsernames.add("admin");
        validUsernames.add("user");
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
        return validUsernames.contains(username);
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long");
        }
        return true; // We're not using password strength here, so we're just returning true.
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}