import java.security.InvalidParameterException;

public class java_01081_CredentialValidator_A01 {

    // Hardcoded passwords for simplicity. In a real scenario, these should be stored in a secure way.
    private static final String HARDCODED_PASSWORD = "password";

    // This is a simple credential validator. It only allows access if the user's password is correct.
    public boolean validateCredentials(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // In a real scenario, we should never store passwords in plain text. Always store hashes.
        // This is a simplification and should not be used in a real scenario.
        if (!password.equals(HARDCODED_PASSWORD)) {
            return false;
        }

        return true;
    }
}