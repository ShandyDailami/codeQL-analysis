import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class java_22784_SessionManager_A08 {
    private Map<UUID, String> sessionMap;

    public java_22784_SessionManager_A08() {
        sessionMap = new LinkedHashMap<>();
    }

    public String createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId.toString();
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            return sessionMap.get(UUID.fromString(sessionId));
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            sessionMap.remove(UUID.fromString(sessionId));
        }
    }
}