import java.util.HashMap;
import java.util.Map;

public class java_02203_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02203_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "value1");
        sessionManager.createSession("session2", "value2");

        System.out.println("Value from session1: " + sessionManager.getSession("session1"));
        System.out.println("Value from session2: " + sessionManager.getSession("session2"));

        sessionManager.removeSession("session1");

        System.out.println("Value from session1 after removal: " + sessionManager.getSession("session1"));
    }
}