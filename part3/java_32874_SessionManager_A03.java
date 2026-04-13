import java.util.HashMap;
import java.util.Map;

public class java_32874_SessionManager_A03 {

    private Map<String, String> sessionMap;

    // Create the SessionManager with an empty session map
    public java_32874_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String sessionId, String userId) {
        // Check if the sessionId or userId is null
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("SessionId and UserId cannot be null");
        }

        // Check if the session is already started
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the provided id already exists");
        }

        // If all checks pass, add the session to the map
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to end a session
    public String endSession(String sessionId) {
        // Check if the sessionId is null
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId cannot be null");
        }

        // Check if the session is already ended
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the provided id exists");
        }

        // If all checks pass, remove the session from the map
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        return userId;
    }

    // Method to get the userId for a given sessionId
    public String getUserId(String sessionId) {
        // Check if the sessionId is null
        if (sessionId == null) {
            throw new IllegalArgumentException("SessionId cannot be null");
        }

        // Check if the session is in the map
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the provided id exists");
        }

        // If all checks pass, return the userId for the session
        return sessionMap.get(sessionId);
    }
}