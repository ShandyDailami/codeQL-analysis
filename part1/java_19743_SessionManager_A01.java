import java.util.HashMap;

public class java_19743_SessionManager_A01 {
    private HashMap<String, String> userMap;
    private HashMap<String, String> sessionMap;

    public java_19743_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public String createSession(String username) {
        String sessionId = "session-" + System.currentTimeMillis();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        userMap.remove(username);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String username, String password) {
        String storedPassword = userMap.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}