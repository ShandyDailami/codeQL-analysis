import java.util.HashMap;
import java.util.Map;

public class java_05930_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05930_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // This is a naive way of generating session id. It's not secure
        // for real-world application.
        String sessionId = username;
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + getUserName(sessionId));
    }
}