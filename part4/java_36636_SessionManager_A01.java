import java.util.HashMap;

public class java_36636_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_36636_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session already exists for user with id: " + userId);
        } else {
            sessions.put(sessionId, userId);
            System.out.println("Session created for user with id: " + userId);
        }
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String userId = sessions.get(sessionId);
            sessions.remove(sessionId);
            System.out.println("Session deleted for user with id: " + userId);
        } else {
            System.out.println("No session exists for the provided session id.");
        }
    }
}