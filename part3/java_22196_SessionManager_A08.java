import java.util.HashMap;
import java.util.Map;

public class java_22196_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_22196_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Object());
    }

    public void addToSession(String sessionId, Object object) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, object);
        } else {
            System.out.println("Session not found.");
        }
    }

    public Object getFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("session1");
        manager.addToSession("session1", "Hello, World!");
        Object object = manager.getFromSession("session1");

        System.out.println(object); // Should print "Hello, World!"
    }
}