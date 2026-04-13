import java.util.HashMap;

public class java_16129_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_16129_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (validateCredentials(username, password)) {
            sessionMap.put(username, "SESSION_ACTIVE");
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Authentication failed for user: " + username);
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session for user: " + username);
        }
    }

    public String getSessionStatus(String username) {
        return sessionMap.getOrDefault(username, "No active session");
    }

    private boolean validateCredentials(String username, String password) {
        // Mock authentication logic here. For simplicity, we'll assume username and password are correct
        return username.equals("admin") && password.equals("password");
    }
}