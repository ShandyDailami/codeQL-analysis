import java.util.HashMap;
import java.util.UUID;

public class java_06835_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_06835_SessionManager_A03() {
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
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}