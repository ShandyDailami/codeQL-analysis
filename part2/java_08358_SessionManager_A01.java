import java.util.HashMap;
import java.util.Map;

public class java_08358_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_08358_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (sessions.containsKey(userId)) {
            System.out.println("Error: Session already exists for user: " + userId);
        } else {
            sessions.put(userId, sessionId);
        }
    }

    public void deleteSession(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.remove(userId);
        } else {
            System.out.println("Error: No session exists for user: " + userId);
        }
    }

    public String getSession(String userId) {
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        } else {
            return null;
        }
    }

    public void updateSession(String userId, String newSessionId) {
        if (sessions.containsKey(userId)) {
            sessions.put(userId, newSessionId);
        } else {
            System.out.println("Error: No session exists for user: " + userId);
        }
    }
}