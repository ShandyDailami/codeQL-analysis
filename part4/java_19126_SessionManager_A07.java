import java.util.HashMap;
import java.util.Map;

public class java_19126_SessionManager_A07 {
    private Map<String, String> userMap;
    private Map<String, String> passwordMap;
    private Map<String, String> sessionMap;
    private int sessionIdCounter;

    public java_19126_SessionManager_A07() {
        userMap = new HashMap<>();
        passwordMap = new HashMap<>();
        sessionMap = new HashMap<>();
        sessionIdCounter = 0;

        // Initial users and passwords for demonstration
        userMap.put("user", "password");
        passwordMap.put("user", "password");
    }

    public String login(String user, String password) {
        if (userMap.containsKey(user) && passwordMap.containsKey(user) && userMap.get(user).equals(passwordMap.get(user))) {
            sessionIdCounter++;
            String sessionId = "session_" + sessionIdCounter;
            sessionMap.put(sessionId, user);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void logout(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}