import java.util.HashMap;
import java.util.Map;

public class java_10441_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_10441_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userID, String sessionID) {
        sessionMap.put(sessionID, userID);
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("user1", "session1");
        if (sm.isValidSession("session1")) {
            System.out.println(sm.getUserID("session1")); // "user1"
            sm.endSession("session1");
        }
        sm.startSession("user2", "session2");
        if (sm.isValidSession("session2")) {
            System.out.println(sm.getUserID("session2")); // "user2"
            sm.endSession("session2");
        }
    }
}