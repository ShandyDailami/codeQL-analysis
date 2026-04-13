import java.util.HashMap;
import java.util.Map;

public class java_18694_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_18694_SessionManager_A07() {
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

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session exists for: " + sessionId);
        } else {
            System.out.println("No session exists for: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession("session1");
        String session2 = sessionManager.createSession("session2");

        sessionManager.checkSession("session1");
        sessionManager.checkSession("session2");

        sessionManager.deleteSession("session1");

        sessionManager.checkSession("session1");
    }
}