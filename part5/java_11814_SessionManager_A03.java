import java.util.HashMap;
import java.util.UUID;

public class java_11814_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_11814_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public UUID createSession(String data) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, data);
        return sessionId;
    }

    public String getSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}