import java.util.HashMap;

public class java_00396_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_00396_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session ID: " + sessionId + " is valid.");
        } else {
            System.out.println("Session ID: " + sessionId + " is not valid.");
            deleteSession(sessionId);
        }
    }
}