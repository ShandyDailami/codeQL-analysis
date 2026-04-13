import java.util.HashMap;
import java.util.UUID;

public class java_17193_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_17193_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}