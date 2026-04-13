import java.util.HashMap;
import java.util.Map;

public class java_16063_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16063_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "valid");
    }

    public boolean isSessionValid(String username) {
        if (!sessionMap.containsKey(username)) {
            System.out.println("User " + username + " not found. Session has expired.");
            return false;
        }

        if ("valid".equals(sessionMap.get(username))) {
            return true;
        } else {
            System.out.println("Session invalidated for user " + username);
            return false;
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }
}