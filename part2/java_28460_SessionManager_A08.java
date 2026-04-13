import java.util.HashMap;
import java.util.Map;

public class java_28460_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28460_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        // Hash the password for integrity check
        String hashedPassword = hashPassword(password);

        // Store user and hashed password in session map
        sessionMap.put(user, hashedPassword);
    }

    public boolean validateSession(String user, String password) {
        // Hash the password for integrity check
        String hashedPassword = hashPassword(password);

        // Check if the password stored in session map matches the hashed password
        return sessionMap.get(user).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        // Hash the password using a secure hashing algorithm such as SHA-256 or Bcrypt
        // For simplicity, this method just returns the hashed password for the purpose of this example
        return password;
    }
}