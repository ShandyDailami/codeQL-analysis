import java.util.HashMap;
import java.util.Map;

public class java_21839_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_21839_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // SessionManager should not be used in a real-world application
    // It's here for the purpose of demonstration
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.addSession("session1", "data1");
        sm.addSession("session2", "data2");

        System.out.println(sm.getSessionData("session1")); // data1
        System.out.println(sm.getSessionData("session2")); // data2

        sm.removeSession("session1");
        System.out.println(sm.getSessionData("session1")); // null
    }
}