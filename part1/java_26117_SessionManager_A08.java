import java.util.HashMap;
import java.util.Map;

public class java_26117_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26117_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("s1", "Session Value 1");
        sm.createSession("s2", "Session Value 2");

        System.out.println("Session 1: " + sm.getSession("s1"));
        System.out.println("Session 2: " + sm.getSession("s2"));

        sm.deleteSession("s1");

        System.out.println("Session 1 after deletion: " + sm.getSession("s1"));
    }
}