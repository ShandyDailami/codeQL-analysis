import java.util.HashMap;

public class java_32126_SessionManager_A07 {

    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_32126_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    // a. Add a session method
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        userMap.put(userId, sessionId);
    }

    // b. Implement a logout method
    public void logout(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            userMap.remove(userId);
        }
    }

    // c. Implement a check user logged in method
    public boolean isUserLoggedIn(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // d. Implement a get user method
    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // e. Do not use external libraries for session management.
}