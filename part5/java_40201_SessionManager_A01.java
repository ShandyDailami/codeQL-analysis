import java.util.HashMap;
import java.util.UUID;

public class java_40201_SessionManager_A01 {
    private HashMap<UUID, String> sessionMap;

    public java_40201_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionName);
        return sessionId.toString();
    }

    public String getSessionName(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}