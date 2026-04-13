import java.util.HashMap;
import java.util.Map;

public class java_32553_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32553_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userName);
        System.out.println("Starting session for user " + userName + " with ID " + sessionId);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ending session for user " + userName + " with ID " + sessionId);
    }
}