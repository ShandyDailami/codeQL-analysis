import java.util.HashMap;
import java.util.Map;

public class java_33698_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_33698_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session Already Exists";
        } else {
            sessionMap.put(sessionId, userId);
            return "Success: Session Created";
        }
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session Doesn't Exists";
        }
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session Destroyed";
        } else {
            return "Error: Session Doesn't Exists";
        }
    }
}