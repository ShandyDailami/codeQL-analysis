import java.util.HashMap;
import java.util.Map;

public class java_12995_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_12995_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session Already Exists";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Success";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success";
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session Does Not Exists";
        }
    }
}