import java.util.HashMap;
import java.util.Map;

public class java_12687_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_12687_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("New session started. ID: " + sessionId + ", User ID: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended. ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("No active session with ID: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("s1", "u1");
        sessionManager.startSession("s2", "u2");
        sessionManager.endSession("s1");
        sessionManager.startSession("s3", "u3");
    }
}