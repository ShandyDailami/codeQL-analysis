import java.util.HashMap;
import java.util.UUID;

public class java_39113_SessionManager_A07 {
    private HashMap<UUID, String> sessionMap;

    public java_39113_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, user);
        return uuid.toString();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            return sessionMap.get(UUID.fromString(sessionId));
        } else {
            return "Session not found";
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}