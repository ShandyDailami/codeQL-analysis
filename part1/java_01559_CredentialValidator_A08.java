import java.security.InvalidParameterException;
import java.util.Arrays;

public class java_01559_CredentialValidator_A08 {

    // Hard-coded list of accepted usernames and passwords
    private static final String[][] acceptedCredentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean isValidCredentials(String username, String password) {
        // If username or password is null, it is not valid.
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Check if the username and password match any of the accepted credentials.
        for (String[] credentials : acceptedCredentials) {
            if (Arrays.equals(credentials, new String[]{username, password})) {
                return true;
            }
        }

        return false;
    }
}