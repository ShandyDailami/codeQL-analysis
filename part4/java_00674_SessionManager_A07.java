import java.util.HashMap;
import java.util.Map;

public class java_00674_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00674_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + userName);
    }

    private String generateSessionId() {
        // This is a dummy session id generation. In a real-world application, you would need a more complex algorithm.
        return "sessionId";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("User1");
        sessionManager.startSession("User2");
        sessionManager.startSession("User3");
        sessionManager.endSession("sessionId");
    }
}