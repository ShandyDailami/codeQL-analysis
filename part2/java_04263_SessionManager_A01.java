import java.util.HashMap;
import java.util.Map;

public class java_04263_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_04263_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessions.put(username, sessionId);
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    public void deleteSession(String username) {
        sessions.remove(username);
    }

    public boolean isSessionValid(String username, String sessionId) {
        if (sessions.containsKey(username)) {
            return sessions.get(username).equals(sessionId);
        }
        return false;
    }
}