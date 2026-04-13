import java.util.HashMap;
import java.util.Map;

public class java_01852_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_01852_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new InvalidSessionException("Invalid session");
        }

        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new InvalidSessionException("Invalid session");
        }

        sessionMap.remove(sessionId);
    }
}