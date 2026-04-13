import java.util.HashMap;
import java.util.Map;

public class java_13545_SessionManager_A07 {
    // This map will hold our sessions. It's important to note that this is a simple in-memory storage and should not be used in a real-world application.
    private Map<String, String> sessionMap;

    // We initialize the session map when we create an instance of the session manager.
    public java_13545_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // This method will add a new session to our map.
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // This method will validate the session. If the session exists in our map and the user is authenticated, the method will return true. Otherwise, it will return false.
    public boolean validateSession(String sessionId, String userId) {
        if(sessionMap.containsKey(sessionId)) {
            if(sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }

    // This method will invalidate a session. If the session exists in our map, the method will remove it from the map.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}