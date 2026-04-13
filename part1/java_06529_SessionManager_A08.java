import java.util.HashMap;

public class java_06529_SessionManager_A08 {
    // The main data structure is a HashMap
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_06529_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists with ID: " + sessionId;
        } else {
            sessionMap.put(sessionId, "Active");
            return "Success: Session created with ID: " + sessionId;
        }
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session exists with ID: " + sessionId;
        } else if (sessionMap.get(sessionId).equals("Expired")) {
            return "Error: Session has expired with ID: " + sessionId;
        } else {
            return "Success: Session validated with ID: " + sessionId;
        }
    }

    // Method to terminate a session
    public String terminateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session exists with ID: " + sessionId;
        } else {
            sessionMap.put(sessionId, "Expired");
            return "Success: Session terminated with ID: " + sessionId;
        }
    }
}