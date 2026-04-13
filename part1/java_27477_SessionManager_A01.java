import java.util.HashMap;

public class java_27477_SessionManager_A01 {
    private HashMap<String, String> userMap = new HashMap<>();
    private HashMap<String, String> sessionMap = new HashMap<>();

    public java_27477_SessionManager_A01() {
        userMap.put("admin", "password");
    }

    public String createSession(String username, String password) {
        if (validateUser(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            return null;
        }
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return Long.toString(System.currentTimeMillis());
    }

    private boolean validateUser(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}