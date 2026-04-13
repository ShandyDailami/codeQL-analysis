import java.util.HashMap;
import java.util.Map;

public class java_10522_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10522_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUserId(String sessionId, String newUserId) {
        if(isValidSession(sessionId)) {
            sessionMap.put(sessionId, newUserId);
        } else {
            System.out.println("Invalid session");
        }
    }

    public void checkAccessControl(String sessionId) {
        if(!isValidSession(sessionId)) {
            System.out.println("Access Denied: Invalid session");
            return;
        }

        String userId = getUserId(sessionId);

        // Simulate checking access control for user with id 'userId'
        if("A01_BrokenAccessControl".equals(userId)) {
            System.out.println("Access Denied: User " + userId + " has access control violation");
        } else {
            System.out.println("Access Granted: User " + userId + " is not in violation of access control");
        }
    }
}