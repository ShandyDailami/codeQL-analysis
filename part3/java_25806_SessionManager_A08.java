import java.util.HashMap;
import java.util.Map;

public class java_25806_SessionManager_A08 {
    private Map<String, String> credentials;

    public java_25806_SessionManager_A08() {
        // Simulated credentials.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean login(String username, String password) {
        // Simulated comparison.
        if (this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Login attempt.
        boolean loggedIn = sm.login("user1", "password1");
        if (loggedIn) {
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }
    }
}