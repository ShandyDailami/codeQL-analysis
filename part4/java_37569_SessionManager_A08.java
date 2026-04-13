import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_37569_SessionManager_A08 {
    private Map<UUID, String> sessionMap;

    public java_37569_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId.toString();
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            sessionMap.put(UUID.fromString(sessionId), newSessionData);
        }
    }
}