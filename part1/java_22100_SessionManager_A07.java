import java.util.HashMap;
import java.util.Map;

public class java_22100_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22100_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (authenticateUser(user, password)) {
            sessionMap.put("user", user);
            System.out.println("User " + user + " started a session.");
        } else {
            System.out.println("Authentication failed for user " + user + ".");
        }
    }

    public void endSession(String user) {
        if (sessionMap.containsKey("user") && sessionMap.get("user").equals(user)) {
            sessionMap.remove("user");
            System.out.println("User " + user + " ended his/her session.");
        } else {
            System.out.println("No active session found for user " + user + ".");
        }
    }

    private boolean authenticateUser(String user, String password) {
        // Simulate authentication by checking if the user is 'admin'
        return "admin".equals(user) && "password".equals(password);
    }
}