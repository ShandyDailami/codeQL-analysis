import java.util.HashMap;
import java.util.Map;

public class java_03616_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_03616_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started for user: " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No session exists to end!");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("A07_AuthFailure1", "John");
        sm.startSession("A07_AuthFailure2", "Mary");
        sm.endSession("A07_AuthFailure1");
        sm.startSession("A07_AuthFailure3", "James");
    }
}