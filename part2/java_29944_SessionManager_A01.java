import java.util.HashMap;
import java.util.Map;

public class java_29944_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_29944_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean checkAccessPermission(String sessionId, String requiredPermission) {
        if (!isSessionValid(sessionId)) {
            System.out.println("Session is not valid!");
            return false;
        }

        String userId = getUserIdFromSession(sessionId);
        // In a real-world scenario, this would be a more complex permission check
        // For simplicity, we're just checking if the user has the required permission
        // This is not a security-sensitive operation, but it's a simple demonstration

        if (userId.equals("admin")) {
            System.out.println("User " + userId + " has the required permission!");
            return true;
        } else {
            System.out.println("User " + userId + " does not have the required permission!");
            return false;
        }
    }
}