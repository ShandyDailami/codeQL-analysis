import java.util.HashMap;
import java.util.Map;

public class java_31876_SessionManager_A01 {
    // A simple in-memory storage for session data
    private Map<String, String> sessionMap;

    public java_31876_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String userId) {
        // In a real application, you would want to use a more secure way to generate a session ID
        // In this example, we're just generating a random session ID
        String sessionId = String.valueOf(Math.random() * 1000000);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method for retrieving a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method for destroying a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}