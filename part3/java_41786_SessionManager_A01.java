import java.util.HashMap;
import java.util.Map;

public class java_41786_SessionManager_A01 {
    // private data structure to store sessions
    private Map<String, String> sessionMap;

    public java_41786_SessionManager_A01() {
        // Initialize sessionMap
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return "Error: Session ID already in use";
        }
        sessionMap.put(sessionId, "Active");
        return "Success";
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID does not exist";
        }
        sessionMap.remove(sessionId);
        return "Success";
    }

    // Method to update the status of a session
    public String updateSessionStatus(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID does not exist";
        }
        sessionMap.replace(sessionId, "Inactive");
        return "Success";
    }

    // Method to get the status of a session
    public String getSessionStatus(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            return "Error: Session ID does not exist";
        }
        return sessionMap.get(sessionId);
    }
}