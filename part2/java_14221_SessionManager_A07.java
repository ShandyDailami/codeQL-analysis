import java.util.HashMap;
import java.util.Map;

public class java_14221_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14221_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "value1");
        System.out.println(manager.getSessionValue("session1"));
        manager.closeSession("session1");
    }
}