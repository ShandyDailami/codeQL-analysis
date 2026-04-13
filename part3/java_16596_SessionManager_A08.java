import java.util.HashMap;

public class java_16596_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_16596_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.nanoTime());
        this.sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return this.sessions.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }

    // Here's a method for checking if a session is valid
    public boolean isValidSession(String sessionId) {
        return this.sessions.containsKey(sessionId);
    }
}