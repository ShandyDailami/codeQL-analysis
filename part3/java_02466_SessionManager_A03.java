import java.util.HashMap;
import java.util.Map;

public class java_02466_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02466_SessionManager_A03() {
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

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("session1", "sessionData1");
        sm.createSession("session2", "sessionData2");

        System.out.println("Session 1 Data: " + sm.getSessionData("session1"));
        System.out.println("Session 2 Data: " + sm.getSessionData("session2"));

        sm.deleteSession("session1");

        System.out.println("Session 1 is active: " + sm.isSessionActive("session1"));
    }
}