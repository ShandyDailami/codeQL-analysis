import java.util.HashMap;
import java.util.Map;

public class java_29408_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29408_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add other methods as necessary
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        String user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user);

        sessionManager.deleteSession(sessionId);
    }
}