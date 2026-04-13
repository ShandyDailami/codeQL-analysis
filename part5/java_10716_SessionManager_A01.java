import java.util.HashMap;
import java.util.UUID;

public class java_10716_SessionManager_A01 {
    private HashMap<UUID, String> sessionMap;

    public java_10716_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String data) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, data);
        return sessionId.toString();
    }

    public String getData(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            return sessionMap.get(UUID.fromString(sessionId));
        } else {
            return "Invalid session ID";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            sessionMap.remove(UUID.fromString(sessionId));
            return "Session deleted";
        } else {
            return "Invalid session ID";
        }
    }
}