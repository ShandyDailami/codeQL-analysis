import java.util.HashMap;
import java.util.Map;

public class java_13044_SessionManager_A07 {
    private Map<String, String> userDatabase;

    public java_13044_SessionManager_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("alice", "password123");
        userDatabase.put("bob", "password456");
    }

    public String authenticate(String username, String password) {
        String storedPassword = userDatabase.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return "Welcome, " + username + "!";
        } else {
            throw new AuthenticationFailureException();
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Authenticate with valid credentials
        try {
            System.out.println(manager.authenticate("alice", "password123"));
        } catch (AuthenticationFailureException e) {
            System.out.println("Authentication failed.");
        }

        // Authenticate with invalid credentials
        try {
            System.out.println(manager.authenticate("alice", "wrongpassword"));
        } catch (AuthenticationFailureException e) {
            System.out.println("Authentication failed.");
        }
    }
}

class AuthenticationFailureException extends RuntimeException {
    public java_13044_SessionManager_A07() {
        super("Authentication failed.");
    }
}