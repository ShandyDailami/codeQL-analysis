import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Map;
import javax.security.auth.login.CredentialException;

public class java_00840_CredentialValidator_A07 {
    private static final String USERNAME = "bob";
    private static final String PASSWORD = "$2a$10$e.LlfVSXq4Qr1Vl.j3VhZe"; // This is a BCrypt hash

    public static void main(String[] args) {
        Map<String, String> userCredentials = Map.of("username", "bob", "password", "password");
        validate(userCredentials);
    }

    public static void validate(Map<String, String> userCredentials) {
        if (!isValidUsername(userCredentials.get("username"))) {
            throw new CredentialException("Invalid username");
        }

        if (!isValidPassword(userCredentials.get("password"))) {
            throw new CredentialException("Invalid password");
        }
    }

    private static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty();
    }

    private static boolean isValidPassword(String password) {
        if (!isValidPassword(password)) {
            throw new InvalidParameterException("Invalid password");
        }

        return true;
    }
}