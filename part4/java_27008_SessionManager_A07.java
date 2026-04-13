import java.util.HashMap;
import java.util.Map;

public class java_27008_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27008_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user " + username);
    }
}