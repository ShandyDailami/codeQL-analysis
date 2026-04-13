import java.util.HashMap;
import java.util.Map;

public class java_21265_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21265_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session for user A07_AuthFailure
        String sessionIdA07 = "A07_AuthFailure";
        String userA07 = "A07_AuthFailure";
        sessionManager.createSession(userA07, sessionIdA07);

        // Attempting to access a protected resource
        String userCurrent = sessionManager.getSession(sessionIdA07);

        // A user trying to access a protected resource should be logged out
        if (userCurrent != userA07) {
            System.out.println("Access Denied: " + userA07 + " tried to access protected resource");
            sessionManager.deleteSession(sessionIdA07);
        } else {
            System.out.println("Access Granted: " + userA07 + " accessed protected resource");
        }
    }
}