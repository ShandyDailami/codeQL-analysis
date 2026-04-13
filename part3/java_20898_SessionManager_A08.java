import java.util.HashMap;
import java.util.Map;

public class java_20898_SessionManager_A08 {

    // A simple in-memory session store
    private Map<String, String> sessionStore;

    public java_20898_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String user) {
        String sessionId = UUID.randomUUID().toString(); // generate a unique session id
        sessionStore.put(sessionId, user);
        return sessionId;
    }

    // Method to check if a session is still valid
    public String checkSession(String sessionId) {
        if (sessionStore.containsKey(sessionId)) {
            return sessionStore.get(sessionId);
        } else {
            System.out.println("Session expired");
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}