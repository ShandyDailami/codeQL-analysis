import java.util.HashMap;
import java.util.Map;

public class java_18677_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18677_SessionManager_A08() {
        sessionMap = new HashMap<>();
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

    // Additional methods for integrity checking

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isUserNameValid(String userName) {
        for (String sessionId : sessionMap.keySet()) {
            if (sessionMap.get(sessionId).equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSessionAndUserNameValid(String sessionId, String userName) {
        return sessionMap.containsKey(sessionId) && sessionMap.get(sessionId).equals(userName);
    }
}