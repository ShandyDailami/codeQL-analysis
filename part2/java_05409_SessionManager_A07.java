import java.util.HashMap;
import java.util.Map;

public class java_05409_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05409_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (isPasswordStrong(password)) {
            sessionMap.put(user, password);
            System.out.println("Session started for user: " + user);
        } else {
            System.out.println("Failed to start session for user: " + user);
            System.out.println("Password is not strong enough");
        }
    }

    public void endSession(String user) {
        if (sessionMap.containsKey(user)) {
            sessionMap.remove(user);
            System.out.println("Session ended for user: " + user);
        } else {
            System.out.println("Failed to end session for user: " + user);
            System.out.println("No active session found for user: " + user);
        }
    }

    private boolean isPasswordStrong(String password) {
        // Here, we will assume a password is strong if it contains at least one uppercase, one lowercase, one digit and one special character
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#!$%^&*])[A-Za-z0-9#!$%^&*]{8,}$");
    }
}