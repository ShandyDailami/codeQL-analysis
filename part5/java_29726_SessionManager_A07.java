import java.util.HashMap;
import java.util.Map;

public class java_29726_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29726_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        // Sensitive operation 1: Create a session
        // Check if the sessionId already exists in the map
        if(sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists!";
        }
        // If not, add the sessionId-userId pair to the map
        sessionMap.put(sessionId, userId);
        return "Session created successfully!";
    }

    public String getUserId(String sessionId) {
        // Sensitive operation 2: Retrieve user from a session
        // Check if the sessionId exists in the map
        if(!sessionMap.containsKey(sessionId)) {
            return "Error: Session does not exist!";
        }
        // If it exists, return the userId
        return sessionMap.get(sessionId);
    }

    public String endSession(String sessionId) {
        // Sensitive operation 3: End a session
        // Check if the sessionId exists in the map
        if(!sessionMap.containsKey(sessionId)) {
            return "Error: Session does not exist!";
        }
        // If it exists, remove the sessionId-userId pair from the map
        sessionMap.remove(sessionId);
        return "Session ended successfully!";
    }
}