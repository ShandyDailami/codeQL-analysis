import java.util.HashMap;
import java.util.Map;

public class java_17477_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_17477_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already exists: " + sessionId);
        }
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No such session exists: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No such session exists: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("s1", "u1");
        sessionManager.createSession("s2", "u2");

        String userId = sessionManager.getUserId("s1");
        System.out.println("User ID: " + userId); // should print u1

        sessionManager.removeSession("s2");
        sessionManager.getUserId("s2"); // should throw exception

        System.out.println("Valid Session: " + sessionManager.isValidSession("s1")); // should print true
        System.out.println("Valid Session: " + sessionManager.isValidSession("s2")); // should print false
    }
}