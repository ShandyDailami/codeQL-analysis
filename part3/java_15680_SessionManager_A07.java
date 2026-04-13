import java.util.HashMap;
import java.util.Map;

public class java_15680_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_15680_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "Session started for user: " + username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public String getSessionInfo(String username) {
        return sessionMap.get(username);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("John");
        System.out.println(sessionManager.getSessionInfo("John"));

        sessionManager.startSession("Jane");
        System.out.println(sessionManager.getSessionInfo("Jane"));

        sessionManager.endSession("John");
        System.out.println(sessionManager.getSessionInfo("John")); // Should print null

        sessionManager.endSession("Jane");
        System.out.println(sessionManager.getSessionInfo("Jane")); // Should print null
    }
}