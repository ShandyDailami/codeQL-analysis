import java.util.HashMap;
import java.util.UUID;

public class java_03033_SessionManager_A08 {
    private HashMap<UUID, String> sessions;

    public java_03033_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, sessionId.toString());
        return sessions.get(sessionId);
    }

    public String getSession(String sessionId) {
        if (sessions.containsValue(sessionId)) {
            for (HashMap.Entry<UUID, String> entry : sessions.entrySet()) {
                if (entry.getValue().equals(sessionId)) {
                    return entry.getKey().toString();
                }
            }
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsValue(sessionId)) {
            for (HashMap.Entry<UUID, String> entry : sessions.entrySet()) {
                if (entry.getValue().equals(sessionId)) {
                    sessions.remove(entry.getKey());
                    break;
                }
            }
        }
    }
}