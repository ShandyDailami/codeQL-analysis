import java.util.HashMap;
import java.util.Map;

public class java_42021_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private String password;

    public java_42021_SessionManager_A07(String password) {
        this.password = password;
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        if (checkPassword(username)) {
            sessionMap.put(sessionId, username);
        } else {
            System.out.println("Invalid password for user: " + username);
        }
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId) && checkPassword(sessionMap.get(sessionId))) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid sessionId: " + sessionId);
            return null;
        }
    }

    private boolean checkPassword(String username) {
        // This method will be used to check the password.
        // For now, we are just returning true if the username is "admin",
        // as this is a simplistic example. In a real application,
        // you should use a more secure way to check the password.
        return "admin".equals(username);
    }
}