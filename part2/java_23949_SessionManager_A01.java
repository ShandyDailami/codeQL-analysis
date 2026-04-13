import java.util.HashMap;
import java.util.Map;

public class java_23949_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_23949_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "No session found for the user.";
        }
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public void updateSession(String userId, String newSessionId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.replace(userId, newSessionId);
        } else {
            System.out.println("No session found for the user.");
        }
    }
}