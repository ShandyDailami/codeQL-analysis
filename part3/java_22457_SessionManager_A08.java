import java.util.HashMap;
import java.util.Map;

public class java_22457_SessionManager_A08 {
    // User data
    private Map<String, String> userData;

    // Session data
    private Map<String, String> sessionData;

    public java_22457_SessionManager_A08() {
        userData = new HashMap<>();
        sessionData = new HashMap<>();
    }

    public void login(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            userData.put("username", username);
            sessionData.put("sessionId", "validSession");
            System.out.println("User logged in successfully");
        } else {
            System.out.println("Login failed");
        }
    }

    public void logout(String sessionId) {
        if (sessionData.containsKey("sessionId") && sessionData.get("sessionId").equals("validSession")) {
            if (sessionData.get("sessionId").equals(sessionId)) {
                sessionData.remove("sessionId");
                userData.remove("username");
                System.out.println("User logged out successfully");
            } else {
                System.out.println("Invalid session");
            }
        } else {
            System.out.println("No active session found");
        }
    }
}