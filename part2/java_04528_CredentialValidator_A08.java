import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04528_CredentialValidator_A08 {
    // Stored passwords in a HashMap
    private Map<String, String> passwords = new HashMap<>();

    // Adding passwords to the map
    public void addPassword(String user, String password) {
        passwords.put(user, password);
    }

    // CredentialValidator method
    public boolean validate(String user, String password) {
        String hashedPassword = hashPassword(password);

        // If the user exists in the map, and their hashed password matches, return true
        return passwords.containsKey(user) && hashedPassword.equals(passwords.get(user));
    }

    // Method to hash passwords
    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}