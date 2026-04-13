import java.util.HashMap;
import java.util.Map;

public class java_03924_SessionManager_A01 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_03924_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void login(String username, String password) {
        if (isValidUser(username, password)) {
            String sessionId = createSession(username);
            sessionMap.put(sessionId, username);
            System.out.println("Session created for user: " + username);
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void logout(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session closed for user: " + username);
        } else {
            System.out.println("No active session found");
        }
    }

    public boolean isLoggedIn(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    private String createSession(String username) {
        return "session_" + username;
    }

    private boolean isValidUser(String username, String password) {
        // This is a dummy check. In a real-world scenario, you'd want to validate the username and password against a database.
        return username.equals("admin") && password.equals("password");
    }
}