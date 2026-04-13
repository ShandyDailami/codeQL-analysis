import java.util.HashMap;
import java.util.Map;

public class java_30788_SessionManager_A01 {
    private Map<String, String> userMap; // This is a placeholder for a database

    public java_30788_SessionManager_A01() {
        userMap = new HashMap<>();
    }

    public boolean createSession(String username, String password) {
        // This is a placeholder for a secure hashing algorithm
        // For real-world use, this would be a secure way to store passwords
        String hashedPassword = hashPassword(password);
        userMap.put(username, hashedPassword);
        return true;
    }

    public boolean login(String username, String password) {
        if (userMap.containsKey(username)) {
            String hashedPassword = userMap.get(username);
            if (hashedPassword.equals(hashPassword(password))) {
                return true;
            }
        }
        return false;
    }

    private String hashPassword(String password) {
        // Placeholder for a secure hashing algorithm
        return password; // In real-world use, this would be a secure way to hash passwords
    }
}