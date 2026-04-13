import java.util.HashMap;
import java.util.Map;

public class java_12484_SessionManager_A03 {
    // A simple in-memory session storage
    private Map<String, Object> sessionStorage;

    public java_12484_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionStorage.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionStorage.containsKey(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionStorage.replace(sessionId, sessionObject);
    }
}