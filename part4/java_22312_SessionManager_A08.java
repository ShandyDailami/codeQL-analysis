import java.util.HashMap;
import java.util.Map;

public class java_22312_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22312_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userName) {
        if(sessionMap.containsKey(sessionId)) {
            return "Error: Session ID already exists";
        } else {
            sessionMap.put(sessionId, userName);
            return "Success: Session created with ID: " + sessionId;
        }
    }

    public String getUserName(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session ID not found";
        }
    }

    public String deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session deleted with ID: " + sessionId;
        } else {
            return "Error: Session ID not found";
        }
    }
}