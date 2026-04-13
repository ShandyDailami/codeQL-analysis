import java.util.HashMap;
import java.util.Map;

public class java_09883_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_09883_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean checkIfSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean checkIfUsernameExistsInSession(String username, String sessionId) {
        if (checkIfSessionExists(sessionId)) {
            return sessionMap.get(sessionId).equals(username);
        }
        return false;
    }

    public void authFailure(String sessionId) {
        if (checkIfSessionExists(sessionId)) {
            deleteSession(sessionId);
        }
    }
}