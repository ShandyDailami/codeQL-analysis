import java.util.HashMap;

public class java_08981_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_08981_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new SecurityException("Session already exists for user: " + userId);
        } else {
            sessions.put(userId, "session");
        }
    }

    public void endSession(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.remove(userId);
        } else {
            throw new SecurityException("No session exists for user: " + userId);
        }
    }

    public void checkSession(String userId) {
        if (sessions.containsKey(userId)) {
            System.out.println("Session exists for user: " + userId);
        } else {
            throw new SecurityException("No session exists for user: " + userId);
        }
    }
}