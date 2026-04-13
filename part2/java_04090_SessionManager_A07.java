import java.util.HashMap;
import java.util.Map;

public class java_04090_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04090_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session " + sessionId + " started for user " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + userName);
    }

    private String generateSessionId() {
        // This method is left to you, you can use any method to generate a session id
        // For simplicity, let's generate a random id
        return String.valueOf(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("John");
        manager.startSession("Sara");
        manager.endSession("John");
        manager.startSession("John");
    }
}