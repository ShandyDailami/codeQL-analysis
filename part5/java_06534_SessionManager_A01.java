import java.util.HashMap;
import java.util.Map;

public class java_06534_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06534_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkAccessControl(String sessionId) {
        String userName = getUserNameFromSession(sessionId);

        if (userName == null || userName.isEmpty()) {
            System.out.println("Access Denied: No session or session is expired!");
        } else {
            System.out.println("Access Granted: User " + userName + " is accessing the system!");
        }
    }
}