import java.util.Hashtable;
import java.util.UUID;

public class java_13712_SessionManager_A08 {
    private Hashtable<UUID, String> sessions;

    public java_13712_SessionManager_A08() {
        sessions = new Hashtable<>();
    }

    public String createSession(String user) {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, user);
        return uuid.toString();
    }

    public String getSessionUser(String sessionId) {
        return sessions.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessions.remove(UUID.fromString(sessionId));
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(UUID.fromString(sessionId));
    }
}