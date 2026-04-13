import java.util.HashMap;
import java.util.UUID;

public class java_31007_SessionManager_A01 {
    private HashMap<String, String> sessionMap;
    private int sessionCount;

    public java_31007_SessionManager_A01() {
        sessionMap = new HashMap<>();
        sessionCount = 0;
    }

    public String createSession() {
        sessionCount++;
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "Session Data");
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session not found";
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}