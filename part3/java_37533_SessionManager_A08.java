import java.util.HashMap;
import java.util.Map;

public class java_37533_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_37533_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, "active");
        return sessionId;
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return sessionId;
        } else {
            return "Session not found";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session not found";
        }
    }

    public String updateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, "active");
            return sessionId;
        } else {
            return "Session not found";
        }
    }

    public String integrityCheck(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Integrity is maintained";
        } else {
            return "Session not found";
        }
    }

}