import java.util.HashMap;
import java.util.UUID;

public class java_34341_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_34341_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "Active");
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}