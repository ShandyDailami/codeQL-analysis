import java.util.HashMap;

public class java_32207_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_32207_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session Already Exists";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Success: Session Created";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session ID: " + sessionId;
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session Deleted";
        } else {
            return "Error: Session Does Not Exists";
        }
    }

    public String integrityCheck(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session Integrity: Valid";
        } else {
            return "Error: Session Does Not Exists";
        }
    }
}