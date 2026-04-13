import java.util.HashMap;
import java.util.Map;

public class java_22220_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_22220_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String sessionId, String userName) {
        return isValidSession(sessionId) && getUserName(sessionId).equals(userName);
    }

    public void authFailure(String sessionId, String userName) {
        if (!isValidSession(sessionId) || !isValidUser(sessionId, userName)) {
            throw new SecurityFailureException("Authentication failed for user " + userName + " in session " + sessionId);
        }
    }

}