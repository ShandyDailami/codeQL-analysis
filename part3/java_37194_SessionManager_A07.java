import java.util.HashMap;
import java.util.Map;

public class java_37194_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37194_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No session found";
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newUserName) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserName);
        } else {
            System.out.println("No session found to update");
        }
    }
}