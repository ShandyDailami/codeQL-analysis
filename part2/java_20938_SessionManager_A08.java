import java.util.HashMap;
import java.util.Map;

public class java_20938_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_20938_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username, String sessionId) {
        // For simplicity, we'll use an insecure method of generating random sessionId.
        // For real use cases, use a secure method of generating sessionId.
        sessionId = String.valueOf(Math.random() * 1000000);
        sessionMap.put(username, sessionId);
        return sessionId;
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public boolean isValidSession(String username, String sessionId) {
        // For simplicity, we'll only check if the sessionId is in our map.
        // In a real use case, we'll also need to check if the sessionId has not expired.
        return sessionMap.containsKey(username) && sessionMap.get(username).equals(sessionId);
    }

    public void deleteSession(String username) {
        sessionMap.remove(username);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        // Creating a new session for a user
        String sessionId = securityManager.createSession("Alice", null);

        // Getting the session
        String session = securityManager.getSession("Alice");

        // Validating the session
        boolean isValid = securityManager.isValidSession("Alice", session);

        // Deleting the session
        securityManager.deleteSession("Alice");
    }
}