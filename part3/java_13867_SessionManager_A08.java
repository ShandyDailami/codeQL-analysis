import java.util.HashMap;
import java.util.Map;

public class java_13867_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_13867_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessions.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessions.containsKey(sessionId)) {
            sessions.put(sessionId, newSessionData);
        } else {
            System.out.println("No session found with id " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            System.out.println("No session found with id " + sessionId);
        }
    }
}