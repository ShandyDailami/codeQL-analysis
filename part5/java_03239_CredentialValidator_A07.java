import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_03239_CredentialValidator_A07 {

    // Hardcoded for simplicity, in a real-world application, passwords would be stored securely in a secure storage
    private static final Map<String, String> userDatabase = new HashMap<>();

    // Static initializer for userDatabase
    static {
        userDatabase.put("alice", Base64.getEncoder().encodeToString("alice:password".getBytes()));
        userDatabase.put("bob", Base64.getEncoder().encodeToString("bob:password".getBytes()));
    }

    // Method to authenticate user
    public boolean authenticate(String username, String password) {
        String expectedPassword = userDatabase.get(username);

        // Decoding password before comparison
        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String decodedPasswordString = new String(decodedPassword);

        // Compare decoded passwords
        return decodedPasswordString.equals(password);
    }
}