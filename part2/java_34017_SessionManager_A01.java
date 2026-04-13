import java.util.HashMap;
import java.util.Map;

public class java_34017_SessionManager_A01 {

    private static Map<String, String> sessionMap;

    public java_34017_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username) {
        // Generate a session token (could be a random UUID)
        String sessionToken = "SESSION_" + System.currentTimeMillis();
        sessionMap.put(sessionToken, username);
        System.out.println("Created session for user " + username + " with token " + sessionToken);
    }

    public String getUsername(String sessionToken) {
        return sessionMap.get(sessionToken);
    }

    public void endSession(String sessionToken) {
        String username = sessionMap.get(sessionToken);
        sessionMap.remove(sessionToken);
        System.out.println("Ended session for user " + username + " with token " + sessionToken);
    }
}