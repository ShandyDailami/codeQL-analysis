import java.util.HashMap;
import java.util.Map;

public class java_00807_SessionManager_A03 {

    // Use a HashMap for session storage.
    private Map<String, String> sessionMap;

    public java_00807_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to terminate a session.
    public boolean endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return true;
        } else {
            return false;
        }
    }

    // This method is for testing purposes.
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.createSession("session1");
        System.out.println(sessionManager.getSession(sessionId));
        sessionManager.endSession("session1");
    }
}