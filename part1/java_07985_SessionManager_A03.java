import java.util.HashMap;
import java.util.UUID;

public class java_07985_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_07985_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String value) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, value);
        return uuid.toString();
    }

    public String getSessionValue(String sessionId) {
        UUID uuid = UUID.fromString(sessionId);
        return sessionMap.get(uuid);
    }

    public void deleteSession(String sessionId) {
        UUID uuid = UUID.fromString(sessionId);
        sessionMap.remove(uuid);
    }
}