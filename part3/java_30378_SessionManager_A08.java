import java.util.HashMap;
import java.util.Map;

public class java_30378_SessionManager_A08 {

    // This HashMap will hold the session IDs as keys and User objects as values
    private Map<String, User> sessionMap;

    // In real application, you would want to use a thread-safe data structure like ConcurrentHashMap
    // to ensure thread-safety when multiple threads access or modify the session map.
    // But for the sake of simplicity, let's keep it simple.
    public java_30378_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Add a session
    public void addSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Get a user from a session
    public User getUserFromSession(String sessionId) throws SessionNotFoundException {
        User user = sessionMap.get(sessionId);
        if(user == null) {
            throw new SessionNotFoundException("Session not found for sessionId: " + sessionId);
        }
        return user;
    }
}