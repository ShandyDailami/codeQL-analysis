import java.util.HashMap;
import java.util.Map;

public class java_26839_SessionManager_A01 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_26839_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (isValidUser(username, password)) {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private boolean isValidUser(String username, String password) {
        // You would normally connect to a database or other external resource to check the user's credentials here
        // This is a dummy check for the sake of the example
        return username.equals("admin") && password.equals("password");
    }
}