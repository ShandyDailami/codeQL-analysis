import java.util.HashMap;
import java.util.Map;

public class java_23586_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_23586_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Adding session to sessionMap
        sessionMap.put(username, "Active");
    }

    public void endSession(String username) {
        // Removing session from sessionMap
        sessionMap.remove(username);
    }

    public String getSessionStatus(String username) {
        // Checking if session is active
        if(sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            throw new IntegrityFailure("Session not found for username: " + username);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("User1");
        System.out.println(sessionManager.getSessionStatus("User1")); // Should print: Active

        sessionManager.endSession("User1");
        System.out.println(sessionManager.getSessionStatus("User1")); // Should print: Throw IntegrityFailure
    }
}