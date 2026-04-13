import java.util.HashMap;

public class java_38338_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_38338_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session ID already in use";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Success";
        }
    }

    // Method to retrieve data from a session
    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session ID not found";
        }
    }

    // Method to update data in a session
    public String updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newData);
            return "Success";
        } else {
            return "Error: Session ID not found";
        }
    }

    // Method to end a session
    public String endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success";
        } else {
            return "Error: Session ID not found";
        }
    }
}