import java.util.HashMap;
import java.util.Map;

public class java_28362_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_28362_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new SecurityException("Session already started for user: " + userId);
        }
        sessions.put(userId, userId);
    }

    public void endSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new SecurityException("No session started for user: " + userId);
       
        }
        sessions.remove(userId);
    }

    public String getSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new SecurityException("No session started for user: " + userId);
        }
        return sessions.get(userId);
    }
}