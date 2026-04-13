import java.util.HashMap;

public class java_01214_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_01214_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // For simplicity, we're just using the username as the session ID.
        // In a real application, you'd want to use a more secure mechanism.
        sessions.put(username, username);
    }

    public String getSession(String username) {
        if (sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            throw new RuntimeException("Invalid session");
        }
    }

    public void endSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.remove(username);
        } else {
            throw new RuntimeException("Invalid session");
        }
    }
}