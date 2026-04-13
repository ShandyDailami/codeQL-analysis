import java.util.HashMap;
import java.util.UUID;

public class java_25033_SessionManager_A08 {

    private HashMap<UUID, String> sessionMap;

    public java_25033_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public UUID startSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getSessionUserName(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(UUID sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}