import java.util.HashMap;
import java.util.Map;

public class java_27301_SessionManager_A03 {

    private static Map<String, String> sessionMap;

    public java_27301_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession("session1");
        System.out.println("Created session: " + session1);

        String session2 = sessionManager.createSession("session2");
        System.out.println("Created session: " + session2);

        System.out.println("Session 1: " + sessionManager.getSession("session1"));
        System.out.println("Session 2: " + sessionManager.getSession("session2"));

        sessionManager.deleteSession("session1");
        System.out.println("Deleted session: " + session1);

        System.out.println("Session 1: " + sessionManager.getSession("session1"));
    }
}