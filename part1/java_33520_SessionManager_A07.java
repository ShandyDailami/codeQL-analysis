import java.util.HashMap;
import java.util.Map;

public class java_33520_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33520_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
            return;
        }
        String sessionId = generateSessionId();
        sessionMap.put(userId, sessionId);
        System.out.println("Started session for user: " + userId + ", Session ID: " + sessionId);
    }

    private String generateSessionId() {
        // Simulating session ID generation for the purpose of this example.
        // In a real-world scenario, this could be a complex process involving
        // random strings, digits, and potentially other information.
        return "session_" + System.currentTimeMillis();
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            System.out.println("No session exists for user: " + userId);
            return;
        }
        String sessionId = sessionMap.get(userId);
        sessionMap.remove(userId);
        System.out.println("Ended session for user: " + userId + ", Session ID: " + sessionId);
    }
}