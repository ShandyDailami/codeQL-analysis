import java.util.HashMap;
import java.util.UUID;

public class java_02843_SessionManager_A08 {
    private HashMap<UUID, String> sessionMap;

    public java_02843_SessionManager_A08() {
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

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}