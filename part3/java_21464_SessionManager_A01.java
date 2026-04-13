import java.util.HashMap;
import java.util.Map;

public class java_21464_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_21464_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "value1");
        System.out.println(sessionManager.getSessionValue("session1")); // Outputs: value1
        sessionManager.deleteSession("session1");
        System.out.println(sessionManager.getSessionValue("session1")); // Outputs: null
    }
}