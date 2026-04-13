import java.util.HashMap;
import java.util.UUID;

public class java_06619_SessionManager_A07 {

    private HashMap<UUID, String> sessionMap;

    public java_06619_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, username);
        return uuid.toString();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            return sessionMap.get(UUID.fromString(sessionId));
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(UUID.fromString(sessionId))) {
            sessionMap.remove(UUID.fromString(sessionId));
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}