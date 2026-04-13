import java.util.HashMap;
import java.util.Map;

public class java_24228_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_24228_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "data1");
        manager.createSession("session2", "data2");

        System.out.println("Session 1 data: " + manager.getSessionData("session1"));
        System.out.println("Session 2 data: " + manager.getSessionData("session2"));

        manager.deleteSession("session1");
        manager.deleteSession("session2");
    }
}