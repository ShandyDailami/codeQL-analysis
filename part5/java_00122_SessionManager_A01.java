import java.util.HashMap;
import java.util.Map;

public class java_00122_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_00122_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // Here we're adding the userId to the session map, and returning a session id.
        // This is a simple and non-intrusive way of handling session management.
        // In a real-world application, you'd likely want to implement a more secure way to manage sessions.
        sessionMap.put(userId, UUID.randomUUID().toString());
        return sessionMap.get(userId);
    }

    public String getUserId(String sessionId) {
        // Here we're looking up the userId in the session map.
        // In a real-world application, you'd likely want to implement a more secure way to manage sessions.
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        // Here we're checking if the session is valid by looking up the sessionId in the session map.
        // In a real-world application, you'd likely want to implement a more secure way to manage sessions.
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String userId) {
        // Here we're checking if the user is valid by looking up the userId in the session map.
        // In a real-world application, you'd likely want to implement a more secure way to manage sessions.
        return sessionMap.containsKey(userId);
    }
}