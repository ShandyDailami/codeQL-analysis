import java.util.HashMap;
import java.util.UUID;

public class java_04940_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_04940_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public UUID startSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSessionData(UUID sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}