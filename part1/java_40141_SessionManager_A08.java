import java.util.HashMap;
import java.util.Map;

public class java_40141_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_40141_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "Session Started for " + username);
    }

    public void endSession(String username) throws SecurityException {
        if (!sessionMap.containsKey(username)) {
            throw new SecurityException("Missing authentication for user: " + username);
        }
        sessionMap.remove(username);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.startSession("alice");
            sessionManager.startSession("bob");
            sessionManager.endSession("alice");
            sessionManager.endSession("bob");
            sessionManager.endSession("charlie"); // This should throw a SecurityException
        } catch (SecurityException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}