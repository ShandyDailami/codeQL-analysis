import java.util.HashMap;
import java.util.Map;

public class java_14397_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14397_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void login(String username, String password) {
        // This is a placeholder for a more complex password check
        if (username.equals("admin") && password.equals("password")) {
            sessionMap.put("username", username);
            System.out.println("User logged in successfully.");
        } else {
            throw new AuthFailureException();
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void logout(String username) {
        sessionMap.remove(username);
        System.out.println("User logged out successfully.");
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        try {
            manager.login("admin", "password");
            System.out.println("Session: " + manager.getSession("admin"));
            manager.logout("admin");
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed. Please try again.");
        }
    }
}