import java.util.HashMap;

public class java_27273_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_27273_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session created with id: " + sessionId);
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session validated for user: " + sessionMap.get(sessionId));
        } else {
            System.out.println("Invalid session: " + sessionId);
        }
    }

    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session destroyed for user: " + userId);
        } else {
            System.out.println("No session found to destroy: " + sessionId);
        }
    }
}