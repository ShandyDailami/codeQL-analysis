import java.util.HashMap;
import java.util.Map;

public class java_19488_SessionManager_A01 {
    // In a real-world application, the session would not be stored in memory.
    // Instead, it would be stored in a database or another persistent storage system.
    private Map<String, String> sessionMap;

    public java_19488_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // Check if the user has permission to create a session.
        // In a real-world application, this would depend on a security system.
        // In this case, we're just assuming that the user has permission.
        if (hasPermissionToCreateSession(userId)) {
            sessionMap.put(sessionId, userId);
        } else {
            System.out.println("User " + userId + " is not allowed to create a session.");
        }
    }

    public void deleteSession(String sessionId) {
        // Check if the session exists.
        if (sessionMap.containsKey(sessionId)) {
            // Check if the session has the correct user.
            if (isCorrectUser(sessionMap.get(sessionId), sessionId)) {
                sessionMap.remove(sessionId);
            } else {
                System.out.println("The session " + sessionId + " is not for the correct user.");
            }
        } else {
            System.out.println("The session " + sessionId + " does not exist.");
        }
    }

    private boolean hasPermissionToCreateSession(String userId) {
        // Implementation of permission check. In a real-world application, this would depend on a security system.
        // In this case, we're just assuming that users with the 'admin' role have permission to create sessions.
        return "admin".equals(userId);
    }

    private boolean isCorrectUser(String expectedUserId, String sessionId) {
        // In a real-world application, the userId would be fetched from the database.
        // In this case, we're assuming that the sessionId is the correct user.
        return sessionId.equals(expectedUserId);
    }
}