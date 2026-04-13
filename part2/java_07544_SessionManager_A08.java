import java.util.HashMap;
import java.util.Map;

public class java_07544_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_07544_SessionManager_A08() {
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

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
        }
    }

    public boolean checkSessionIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        sessionManager.createSession("session1", "data1");
        sessionManager.createSession("session2", "data2");

        if (sessionManager.checkSessionIntegrity("session1")) {
            System.out.println("Session 1 integrity checked: " + sessionManager.getSessionData("session1"));
        }

        if (sessionManager.checkSessionIntegrity("session2")) {
            System.out.println("Session 2 integrity checked: " + sessionManager.getSessionData("session2"));
        }

        sessionManager.updateSession("session1", "newData1");
        sessionManager.deleteSession("session2");

        if (sessionManager.checkSessionIntegrity("session1")) {
            System.out.println("Session 1 integrity checked: " + sessionManager.getSessionData("session1"));
        }
        if (!sessionManager.checkSessionIntegrity("session2")) {
            System.out.println("Session 2 integrity not checked: " + sessionManager.getSessionData("session2"));
        }
    }
}