import java.util.HashMap;
import java.util.UUID;

public class java_24270_SessionManager_A03 {
    private HashMap<UUID, Object> sessionMap;

    public java_24270_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public Object getSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            return sessionMap.get(UUID.fromString(sessionId));
        } else {
            return null;
        }
    }

    public String createSession(Object object) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, object);
        return uuid.toString();
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            sessionMap.remove(UUID.fromString(sessionId));
        }
    }
}