import java.util.HashMap;
import java.util.Map;

public class java_02363_SessionManager_A07 {
    // This is a simple in-memory session store
    private Map<String, String> sessionMap;

    public java_02363_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // This method will add a session to the session map
    public void addSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
    }

    // This method will remove a session from the session map
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method will check if a session is valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}