import java.util.HashMap;
import java.util.Map;

public class java_12035_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12035_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("s1", "u1");
        sm.startSession("s2", "u2");
        sm.startSession("s3", "u3");

        System.out.println(sm.getUserId("s1"));  // Should print u1
        System.out.println(sm.getUserId("s2"));  // Should print u2
        System.out.println(sm.getUserId("s4"));  // Should throw Invalid session exception

        sm.endSession("s1");
        sm.endSession("s2");
        sm.endSession("s4");  // Should throw Invalid session exception
    }
}