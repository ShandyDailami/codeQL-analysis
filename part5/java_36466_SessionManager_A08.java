import java.util.HashMap;
import java.util.Map;

public class java_36466_SessionManager_A08 {

    private Map<String, String> sessionMap;

    // Constructor
    public java_36466_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method for adding a session
    public String addSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            return "A session with this id already exists";
        } else {
            sessionMap.put(sessionId, userId);
            return "Session created successfully";
        }
    }

    // Method for removing a session
    public String removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session removed successfully";
        } else {
            return "No session with this id exists";
        }
    }

    // Method for getting the user id of a session
    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No session with this id exists";
        }
    }
}