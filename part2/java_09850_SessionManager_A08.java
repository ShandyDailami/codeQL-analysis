import java.util.HashMap;
import java.util.UUID;

public class java_09850_SessionManager_A08 {
    private HashMap<String, String> sessionStorage;

    public java_09850_SessionManager_A08() {
        sessionStorage = new HashMap<>();
    }

    public String createSession(String sessionData) {
        String sessionId = UUID.randomUUID().toString();
        sessionStorage.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        if (!sessionStorage.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionStorage.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        sessionStorage.remove(sessionId);
    }
}