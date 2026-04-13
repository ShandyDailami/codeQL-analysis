import java.util.HashMap;
import java.util.Map;

public class java_19291_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19291_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Alice");

        String sessionId = sessionManager.getUserName("Alice");
        System.out.println("Session ID: " + sessionId);

        sessionManager.endSession(sessionId);
    }
}