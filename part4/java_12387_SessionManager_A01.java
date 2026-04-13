import java.util.HashMap;

public class java_12387_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_12387_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void addSession(String username, String sessionId) {
        sessions.put(sessionId, username);
    }

    public String getUsernameBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Add more methods for managing the session here
}