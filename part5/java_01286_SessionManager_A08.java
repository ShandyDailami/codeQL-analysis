import java.util.HashMap;
import java.util.Map;

public class java_01286_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_01286_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void login(String username, String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            userMap.put("username", username);
        }
    }

    public void logout(String username) {
        if (userMap.containsKey("username") && userMap.get("username").equals(username)) {
            userMap.clear();
        }
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Authenticate the user
        sessionManager.login("admin", "password");

        // Check if the session is null
        if (sessionManager.getSession() == null) {
            System.out.println("No session available.");
        } else {
            System.out.println("Session available.");

            // Destroy the session
            sessionManager.logout("admin");

            // Check if the session is null after logout
            if (sessionManager.getSession() == null) {
                System.out.println("Session destroyed successfully.");
            } else {
                System.out.println("Session still available.");
            }
        }
    }

    private Object getSession() {
        return userMap;
    }
}