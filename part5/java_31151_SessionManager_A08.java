import java.util.HashMap;

public class java_31151_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_31151_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session created with ID: " + sessionId + " and User ID: " + userId);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session found for ID: " + sessionId);
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found for ID: " + sessionId);
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session deleted for ID: " + sessionId);
        } else {
            System.out.println("Session not found for ID: " + sessionId);
        }
    }
}