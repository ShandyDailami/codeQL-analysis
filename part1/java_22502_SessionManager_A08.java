import java.util.HashMap;
import java.util.Map;

public class java_22502_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_22502_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessions.containsKey(userId)) {
            System.out.println("User with id " + userId + " already has a session. Session ID: " + sessions.get(userId));
            return;
        }

        sessions.put(userId, sessionId);
        System.out.println("Started session for user with id " + userId + " with session ID: " + sessionId);
    }

    public void endSession(String userId) {
        if (!sessions.containsKey(userId)) {
            System.out.println("No session exists for user with id " + userId);
            return;
        }

        String sessionId = sessions.get(userId);
        sessions.remove(userId);
        System.out.println("Ended session for user with id " + userId + " with session ID: " + sessionId);
    }
}