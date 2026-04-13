import java.util.*;

public class java_32621_SessionManager_A03 {
    // private fields
    private Map<String, String> sessionMap;

    // constructor
    public java_32621_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // method to create a new session
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session with id: " + sessionId + " already exists.";
        } else {
            sessionMap.put(sessionId, "Created at " + new Date());
            return "Session created with id: " + sessionId;
        }
    }

    // method to delete a session
    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session with id: " + sessionId + " deleted.";
        } else {
            return "Session with id: " + sessionId + " does not exist.";
        }
    }

    // method to update a session
    public String updateSession(String sessionId, String newSessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            sessionMap.put(newSessionId, "Updated at " + new Date());
            return "Session with id: " + sessionId + " updated to: " + newSessionId;
        } else {
            return "Session with id: " + sessionId + " does not exist.";
        }
    }

    // method to get the status of a session
    public String getSessionStatus(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session with id: " + sessionId + " exists. Last updated at: " + sessionMap.get(sessionId);
        } else {
            return "Session with id: " + sessionId + " does not exist.";
        }
    }
}