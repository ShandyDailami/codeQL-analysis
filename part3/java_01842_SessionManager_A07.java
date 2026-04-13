import java.util.HashMap;
import java.util.Map;

public class java_01842_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_01842_SessionManager_A07() {
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

        // Create a session
        String sessionId = "session123";
        String userId = "user123";
        sessionManager.createSession(sessionId, userId);

        // Get the user id from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID: " + user);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}