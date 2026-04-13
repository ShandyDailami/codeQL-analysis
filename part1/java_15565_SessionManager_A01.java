import java.util.HashMap;
import java.util.Map;

public class java_15565_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_15565_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "Session data 1");
        sessionManager.createSession("session2", "Session data 2");

        System.out.println("Session 1 data: " + sessionManager.getSessionData("session1"));
        System.out.println("Session 2 data: " + sessionManager.getSessionData("session2"));

        sessionManager.deleteSession("session1");

        System.out.println("Session 1 data after deletion: " + sessionManager.getSessionData("session1"));
    }
}