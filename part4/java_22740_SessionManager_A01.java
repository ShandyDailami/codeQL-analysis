import java.util.HashMap;
import java.util.Map;

public class java_22740_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22740_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session created for user " + userName + " with session ID " + sessionId);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " deleted");
    }
}