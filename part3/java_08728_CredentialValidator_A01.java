import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;

public class java_08728_CredentialValidator_A01 {

    // A simple in-memory map for testing purposes
    private static HashMap<String, String> credentials = new HashMap<>();

    // Initialize credentials for testing
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Unique method for validation
    public boolean validate(String user, String password) throws InvalidParameterException {
        // We have to check if the user and password are not null
        if (user == null || password == null) {
            throw new InvalidParameterException("User and password cannot be null");
        }

        // We have to check if the user and password exist in our map
        if (!credentials.containsKey(user)) {
            throw new InvalidParameterException("User does not exist");
        }

        // Now we compare the passwords, we use a base64 decoder to compare the hashes
        String hashedPassword = credentials.get(user);
        String hashedInputPassword = new String(Base64.getDecoder().decode(password));

        if (hashedPassword.equals(hashedInputPassword)) {
            return true;
        } else {
            return false;
        }
    }
}