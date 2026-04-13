import java.util.HashMap;
import java.util.Map;

public class java_03641_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03641_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, sessionId);
            System.out.println("Started new session with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id: " + sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }

    public void checkIntegrityFailure(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session integrity failure detected in session with id: " + sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }
}