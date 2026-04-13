import java.util.HashMap;
import java.util.Map;

public class java_05330_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05330_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a new session for user 'Alice' with sessionId '123'
        sessionManager.startSession("Alice", "123");

        // Get the username associated with sessionId '123'
        String username = sessionManager.getUsername("123");
        System.out.println("Username associated with sessionId '123': " + username);

        // End the session associated with sessionId '123'
        sessionManager.endSession("123");

        // Check if the session associated with sessionId '123' is valid
        boolean isValid = sessionManager.isSessionValid("123");
        System.out.println("Is valid session '123'? " + isValid);
    }
}