import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05552_CredentialValidator_A01 {

    // User database
    private Map<String, String> userDatabase;

    public java_05552_CredentialValidator_A01() {
        userDatabase = new HashMap<>();

        // Initialize user database with some dummy data
        userDatabase.put("admin", "password");
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Decode the password from base64
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        // Verify the password against the stored password
        String storedPassword = userDatabase.get(username);
        return decodedPasswordString.equals(storedPassword);
    }
}