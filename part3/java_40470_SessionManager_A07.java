import java.util.HashMap;
import java.util.Map;

public class java_40470_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40470_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("user1", "session1");
        sessionManager.createSession("user2", "session2");

        System.out.println("Session1: " + sessionManager.getSession("user1"));
        System.out.println("Session2: " + sessionManager.getSession("user2"));

        sessionManager.endSession("user1");

        System.out.println("After session1 ended: " + sessionManager.getSession("user1"));
    }
}