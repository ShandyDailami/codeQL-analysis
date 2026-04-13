import java.util.HashMap;
import java.util.UUID;

public class java_06038_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_06038_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, uuid.toString());
        return uuid.toString();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}