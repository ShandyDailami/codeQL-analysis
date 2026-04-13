import java.util.HashMap;
import java.util.Map;

public class java_41933_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41933_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void destroySession(String sessionId) {
        deleteSession(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        System.out.println(sessionManager.getSession("session1"));
        System.out.println(sessionManager.getSession("session2"));

        sessionManager.destroySession("session1");
        System.out.println(sessionManager.getSession("session1"));
    }
}