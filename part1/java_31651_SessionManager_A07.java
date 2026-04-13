import java.util.HashMap;

public class java_31651_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_31651_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");

        String userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: user1

        sessionManager.endSession("session1");

        userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: null
    }
}