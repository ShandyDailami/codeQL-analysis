import java.util.HashMap;
import java.util.Map;

public class java_02400_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_02400_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserName) {
        if (!isValidSession(sessionId)) {
            throw new SecurityFailureException("Invalid session: " + sessionId);
        }

        String actualUserName = getUserName(sessionId);
        if (!actualUserName.equals(expectedUserName)) {
            throw new SecurityFailureException("Invalid user: " + actualUserName);
        }
    }
}