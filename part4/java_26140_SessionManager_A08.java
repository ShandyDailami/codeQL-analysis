import java.util.HashMap;
import java.util.Map;

public class java_26140_SessionManager_A08 {

    // private instance of session map
    private Map<String, String> sessionMap;

    // constructor
    public java_26140_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // method to add a session
    public String addSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with ID: " + sessionId);
            return null;
        } else {
            sessionMap.put(sessionId, sessionData);
            return sessionId;
        }
    }

    // method to get data from a session
    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }

    // method to delete a session
    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    // method to validate integrity
    public boolean validateIntegrity(String sessionId) {
        // Assuming that a valid session is one which exists in the session map
        return sessionMap.containsKey(sessionId);
    }
}