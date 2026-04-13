import java.util.HashMap;
import java.util.Map;

public class java_19081_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_19081_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void createSession(String user, String password) {
        // This is a simplistic hashing function for demonstration purposes. In a real-world scenario, you would typically hash the password and store the hash instead of the password itself.
        String hashedPassword = hashPassword(password);
        sessions.put(user, hashedPassword);
    }

    public boolean authenticate(String user, String password) {
        // Similar to the createSession method, this function hashes the entered password and compares it to the stored hash.
        String hashedPassword = sessions.get(user);
        return hashedPassword != null && hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // This is a placeholder for a hashing function. In a real-world scenario, you would use a secure hashing algorithm.
        // In this example, we're just storing the password as is.
        return password;
    }
}