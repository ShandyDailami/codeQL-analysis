import java.util.HashMap;
import java.util.UUID;

public class java_37881_SessionManager_A07 {

    private HashMap<UUID, String> sessions;

    public java_37881_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, username);
        return uuid.toString();
    }

    public String getUsername(String sessionId) {
        return sessions.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessions.remove(UUID.fromString(sessionId));
    }

}