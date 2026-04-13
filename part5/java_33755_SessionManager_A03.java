import java.util.HashMap;

public class java_33755_SessionManager_A03 {
    private HashMap<String, String> sessions;

    public java_33755_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }

    // Method to check if the session is valid
    public boolean isValidSession(String userId, String sessionId) {
        return (sessions.get(userId) != null && sessions.get(userId).equals(sessionId));
    }
}