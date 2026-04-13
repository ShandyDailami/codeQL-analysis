import java.util.HashMap;
import java.util.Map;

public class java_17182_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_17182_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        if (userName != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("Session not found for user: " + sessionId);
        }
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}