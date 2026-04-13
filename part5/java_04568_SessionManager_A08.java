import java.util.HashMap;
import java.util.UUID;

public class java_04568_SessionManager_A08 {
    private HashMap<UUID, String> sessions;

    public java_04568_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public UUID createSession(String user) {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(UUID sessionId) {
        sessions.remove(sessionId);
    }
}