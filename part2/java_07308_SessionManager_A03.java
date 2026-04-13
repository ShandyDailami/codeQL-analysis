import java.util.HashMap;
import java.util.Map;

public class java_07308_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_07308_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        sessionMap.put(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("session1", "data1");
        sm.createSession("session2", "data2");

        System.out.println(sm.getSessionData("session1")); // prints: data1
        System.out.println(sm.getSessionData("session2")); // prints: data2

        sm.updateSession("session1", "new data 1");
        System.out.println(sm.getSessionData("session1")); // prints: new data 1

        sm.deleteSession("session2");
        System.out.println(sm.hasSession("session2")); // prints: false
    }
}