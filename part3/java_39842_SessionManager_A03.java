import java.util.*;

public class java_39842_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39842_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Started");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.getOrDefault(sessionId, "Not Started");
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        String sessionId1 = UUID.randomUUID().toString();
        String sessionId2 = UUID.randomUUID().toString();

        sm.startSession(sessionId1);
        sm.startSession(sessionId2);

        System.out.println(sm.getSessionStatus(sessionId1)); // Should print "Started"
        System.out.println(sm.getSessionStatus(sessionId2)); // Should print "Started"

        sm.endSession(sessionId1);
        sm.endSession(sessionId2);

        System.out.println(sm.getSessionStatus(sessionId1)); // Should print "Not Started"
        System.out.println(sm.getSessionStatus(sessionId2)); // Should print "Not Started"
    }
}