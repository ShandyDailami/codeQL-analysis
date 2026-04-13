import java.util.HashMap;
import java.util.Map;

public class java_21090_SessionManager_A07 extends Exception {
    public java_21090_SessionManager_A07(String message) {
        super(message);
    }
}

public class SessionManager {
    private Map<String, String> sessions;

    public java_21090_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void login(String username, String password) throws AuthFailureException {
        // Assume this is a secure way to authenticate the user
        if (!username.equals("admin") || !password.equals("password")) {
            throw new AuthFailureException("Authentication failure");
        }

        sessions.put("username", username);
    }

    public void logout(String username) throws AuthFailureException {
        if (!sessions.containsValue(username)) {
            throw new AuthFailureException("Logout failure: session not found");
        }

        sessions.remove(username);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.login("admin", "password");

            System.out.println("User is authenticated");
            sessionManager.logout("admin");
            System.out.println("User is logged out");

        } catch (AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}