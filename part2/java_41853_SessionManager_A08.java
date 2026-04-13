import java.util.HashMap;

public class java_41853_SessionManager_A08 {
    private HashMap<String, String> sessionStore;

    public java_41853_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionStore.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}