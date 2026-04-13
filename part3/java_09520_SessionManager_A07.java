import java.util.HashMap;
import java.util.Map;

public class java_09520_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_09520_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");

        if (sessionManager.isValidSession("session1")) {
            String username = sessionManager.getUsername("session1");
            System.out.println("Username is: " + username);
        } else {
            System.out.println("Invalid session");
        }

        sessionManager.endSession("session1");
    }
}