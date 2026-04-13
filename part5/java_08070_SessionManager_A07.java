import java.util.HashMap;
import java.util.Map;

public class java_08070_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08070_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, "Valid Session");
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Authentication Failed!");
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
        System.out.println("Session ended for user: " + username);
    }

    private boolean isValidUser(String username, String password) {
        // Simulate authentication by checking username and password.
        // For real-world application, it should be authenticated against a database.
        return username.equals("admin") && password.equals("password");
    }
}