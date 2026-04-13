import java.util.HashMap;
import java.util.Map;

public class java_19935_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19935_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = "session1";

        sessionManager.createSession(sessionId, userId);

        if (sessionManager.isValidSession(sessionId)) {
            String user = sessionManager.getUserId(sessionId);
            System.out.println("User " + user + " is logged in");
        } else {
            System.out.println("Invalid session");
        }

        sessionManager.destroySession(sessionId);

        if (!sessionManager.isValidSession(sessionId)) {
            System.out.println("Session destroyed");
        } else {
            System.out.println("Session not destroyed");
        }
    }
}