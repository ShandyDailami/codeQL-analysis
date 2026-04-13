import java.util.HashMap;
import java.util.Map;

public class java_41820_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41820_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName + ", Session ID: " + sessionId);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid Session");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            throw new AuthFailureException("Invalid Session");
        }
    }
}