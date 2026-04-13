import java.security.InvalidParameterException;
import java.util.Base64;

public class java_33143_CredentialValidator_A03 {
    private static final String AUTHENTICATOR = "Basic ";

    public static boolean validate(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("User and Password must be provided.");
        }

        // Base64 decoding is performed for simplicity. In a real scenario,
        // the password should be hashed (using a hashing function) and then
        // compared to the stored hash.
        String encodedPassword = new String(Base64.getEncoder().encode(password.getBytes()));

        // Simplified authentication: only users 'user' and 'admin' are allowed.
        if ("user".equals(user) && "admin".equals(encodedPassword)) {
            return true;
        } else if ("admin".equals(user) && "admin".equals(encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}