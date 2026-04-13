import java.util.HashMap;
import java.util.Map;

public class java_30895_SessionManager_A01 {

    // Store user credentials in a map.
    private Map<String, String> userCredentials;

    public java_30895_SessionManager_A01() {
        userCredentials = new HashMap<>();
    }

    // Method to open a session.
    public String openSession(String userName, String password) {
        if (isValidUser(userName, password)) {
            String sessionId = generateSessionId();
            userCredentials.put(sessionId, userName);
            return sessionId;
        } else {
            return null;
        }
    }

    // Method to close a session.
    public void closeSession(String sessionId) {
        String userName = userCredentials.get(sessionId);
        if (userName != null) {
            userCredentials.remove(sessionId);
            System.out.println("Session closed for user: " + userName);
        }
    }

    // Method to check if the provided credentials are valid.
    private boolean isValidUser(String userName, String password) {
        // This is a placeholder for a secure check against a database.
        // In a real scenario, you would need to compare passwords hashed and stored securely.
        return true;
    }

    // Method to generate a session id.
    private String generateSessionId() {
        // This is a simple session id generation. In a real scenario, you would need to use UUIDs.
        return String.valueOf(System.currentTimeMillis());
    }
}