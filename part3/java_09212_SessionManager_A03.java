import java.util.HashMap;

public class java_09212_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_09212_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please use a different session ID.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created with ID: " + sessionId);
        }
    }

    public void validateSession(String sessionId, String expectedUserId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Invalid session ID.");
        } else if (!sessionMap.get(sessionId).equals(expectedUserId)) {
            System.out.println("Invalid session, user ID mismatch.");
        } else {
            System.out.println("Valid session.");
        }
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session does not exist.");
        } else {
            sessionMap.remove(sessionId);
            System.out.println("Session destroyed with ID: " + sessionId);
        }
    }
}