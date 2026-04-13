import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_39813_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39813_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username, String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            sessionMap.put(sessionId, username);
            return "Session created";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session not found";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted";
        } else {
            return "Session not found";
        }
    }

    public String updateSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, username);
            return "Session updated";
        } else {
            return "Session not found";
        }
    }
}