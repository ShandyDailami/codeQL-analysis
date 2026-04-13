import java.util.HashMap;

public class java_05225_SessionManager_A03 {
    // This is a simple in-memory session store. You would likely use a database for a real-world scenario.
    private HashMap<String, String> sessionStore;

    public java_05225_SessionManager_A03() {
        sessionStore = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void setSession(String sessionId, String sessionData) {
        sessionStore.put(sessionId, sessionData);
    }

    public void invalidateSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}