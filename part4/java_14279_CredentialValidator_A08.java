import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14279_CredentialValidator_A08 {

    // For the sake of example, assume we have a hardcoded map of encoded users and passwords
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("alice", Base64.getEncoder().encodeToString("password123".getBytes()));
        userDatabase.put("bob", Base64.getEncoder().encodeToString("password456".getBytes()));
    }

    public boolean validate(String username, String passwordAttempt) {
        String expectedPassword = userDatabase.get(username);

        // If the expected password is null, it means the user does not exist in the database
        if (expectedPassword == null) {
            throw new SecurityException("Invalid username");
        }

        // If the passwords do not match, integrity failure
        if (!expectedPassword.equals(Base64.getEncoder().encodeToString(passwordAttempt.getBytes()))) {
            throw new SecurityException("Invalid password");
        }

        // If we made it here, the passwords match and integrity is good
        return true;
    }
}