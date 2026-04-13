import java.util.HashMap;
import java.util.Map;

public class java_03895_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03895_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        // Here you can implement your security-sensitive operation to start a session for the user.
        // For example, you might add the user to a list of authorized users, or encrypt the sessionId.

        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        // Here you can implement your security-sensitive operation to get the username of the user who is currently logged in.
        // For example, you might return the username from the sessionMap.

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Here you can implement your security-sensitive operation to end the session for the user.
        // For example, you might remove the user from the sessionMap.

        sessionMap.remove(sessionId);
    }
}