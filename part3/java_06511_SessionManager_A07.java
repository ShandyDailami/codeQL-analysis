import java.util.HashMap;
import java.util.Map;

public class java_06511_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06511_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (authenticate(username, password)) {
            sessionMap.put(username, "SESSION_" + System.currentTimeMillis());
        } else {
            throw new AuthFailureException();
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public boolean isSessionActive(String username) {
        return sessionMap.containsKey(username);
    }

    private boolean authenticate(String username, String password) {
        // Implement authentication logic here.
        // This is a placeholder, replace with actual authentication logic.
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.startSession("admin", "password");
            if (sessionManager.isSessionActive("admin")) {
                System.out.println("Session is active");
            } else {
                System.out.println("Session is not active");
            }
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed. Session not started.");
        } finally {
            sessionManager.endSession("admin");
        }
    }
}