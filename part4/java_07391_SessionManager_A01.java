import java.util.HashMap;
import java.util.Map;

public class java_07391_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07391_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUserName(String sessionId, String newUserName) {
        if (isSessionExists(sessionId)) {
            sessionMap.put(sessionId, newUserName);
        } else {
            System.out.println("Session not found!");
        }
    }
}