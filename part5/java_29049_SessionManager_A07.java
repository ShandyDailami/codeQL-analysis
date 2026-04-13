import java.util.HashMap;
import java.util.Map;

public class java_29049_SessionManager_A07 {
    private Map<String, String> userCredentials;

    public java_29049_SessionManager_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin", "password");
    }

    public boolean authenticate(String username, String password) {
        return password.equals(userCredentials.get(username));
    }

    public void startSession(String username) {
        // Implementation of session management would be here
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String username) {
        // Implementation of session management would be here
        System.out.println("Session ended for user: " + username);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        if (sessionManager.authenticate("admin", "password")) {
            sessionManager.startSession("admin");
        } else {
            System.out.println("Authentication failed!");
        }
        sessionManager.endSession("admin");
    }
}