import java.util.HashMap;

public class java_39759_SessionManager_A03 {
    private HashMap<String, Object> sessionMap;

    public java_39759_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object data) {
        String sessionId = UUID.randomUUID().toString(); // generate a random session ID
        sessionMap.put(sessionId, data);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }
}