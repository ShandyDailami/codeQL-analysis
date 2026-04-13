import java.util.HashMap;

public class java_10341_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_10341_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = Integer.toString(sessions.size() + 1); // Assuming session IDs start at 1
        sessions.put(sessionId, userName);
        return sessionId;
    }

    public void logout(String sessionId) {
        sessions.remove(sessionId);
    }

    public String getUserName(String sessionId) {
        return sessions.get(sessionId);
    }
}