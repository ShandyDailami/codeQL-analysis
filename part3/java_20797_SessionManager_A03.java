import java.util.HashMap;
import java.util.Map;

public class java_20797_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20797_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user " + username + " with ID " + sessionId);
   
    }

    private String generateSessionId() {
        // This is a very simplistic way to generate a session id.
        // In a real-world scenario, you should use a more secure way
        // to generate a session id.
        return String.valueOf(System.currentTimeMillis());
    }
}