import java.util.HashMap;
import java.util.Map;

public class java_01348_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01348_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            sessionMap.put(sessionId, userName);
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "User: " + sessionMap.get(sessionId);
        } else {
            return "Session does not exist";
        }
    }

    public String removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session removed successfully";
        } else {
            return "Session does not exist";
        }
    }

    public String updateSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, userName);
            return "Session updated successfully";
        } else {
            return "Session does not exist";
        }
    }
}