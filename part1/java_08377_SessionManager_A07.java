import java.util.HashMap;
import java.util.Map;

public class java_08377_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08377_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user " + userName + ". Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user " + userName + ". Session ID: " + sessionId);
    }

    private String generateSessionId() {
        // This is a very basic implementation, in a real-world application, you'd likely want to use a UUID here.
        return "sessionId" + System.currentTimeMillis();
    }
}