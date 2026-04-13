import java.util.HashMap;
import java.util.Map;

public class java_17314_SessionManager_A07 {

    // The sessions are stored in a HashMap
    private Map<String, String> sessions;

    // Constructor
    public java_17314_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = String.valueOf(System.nanoTime());
        this.sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user for a session
    public String getUserForSession(String sessionId) {
        if(this.sessions.containsKey(sessionId)) {
            return this.sessions.get(sessionId);
        } else {
            throw new RuntimeException("Session not found!");
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }
}