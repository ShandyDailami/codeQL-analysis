import java.util.HashMap;
import java.util.UUID;

public class java_39698_SessionManager_A01 {
    private HashMap<UUID, String> sessionMap;

    public java_39698_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userName);
        return sessionId.toString();
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}