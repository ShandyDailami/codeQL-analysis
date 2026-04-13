import java.util.HashMap;
import java.util.Map;

public class java_04613_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_04613_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void openSession(String username, String password) {
        // Checking if password is secure (e.g., uses complex rules)
        if (isPasswordSecure(password)) {
            System.out.println("Access Denied! The password is secure!");
        } else {
            sessions.put(username, password);
            System.out.println("Session opened for user: " + username);
        }
    }

    public void closeSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.remove(username);
            System.out.println("Session closed for user: " + username);
        } else {
            System.out.println("No active session for user: " + username);
        }
    }

    private boolean isPasswordSecure(String password) {
        // Implementation of complex password security rules here
        // This is a placeholder, real implementation would depend on the rules
        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}");
    }
}