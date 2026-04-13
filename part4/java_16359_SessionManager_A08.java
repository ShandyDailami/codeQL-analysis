import java.util.HashMap;
import java.util.Map;

public class java_16359_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16359_SessionManager_A08() {
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
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Retrieving the user associated with the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User associated with session " + sessionId + " is " + user);

        // Deleting the session
        sessionManager.deleteSession(sessionId);
    }
}