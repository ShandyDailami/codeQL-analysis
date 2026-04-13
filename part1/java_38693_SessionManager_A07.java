import java.util.HashMap;
import java.util.Map;

public class java_38693_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_38693_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username + ". Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + username + ". Session ID: " + sessionId);
   
    }

    private String generateSessionId() {
        // This is a simplistic way of generating a session id. In a real-world scenario, you would need to use a more secure method.
        return String.valueOf(System.currentTimeMillis());
    }
}