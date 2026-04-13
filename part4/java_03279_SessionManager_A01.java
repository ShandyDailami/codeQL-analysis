import java.util.HashMap;
import java.util.Map;

public class java_03279_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03279_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with id " + sessionId + " for user " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id " + sessionId + " for user " + userId);
        } else {
            System.out.println("No session found with id " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("s1", "u1");
        manager.startSession("s2", "u2");
        manager.startSession("s1", "u3"); // This should print "Session with id s1 already exists."
        manager.endSession("s1");
        manager.endSession("s3"); // This should print "No session found with id s3"
    }
}