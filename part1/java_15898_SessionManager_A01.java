import java.util.HashMap;
import java.util.Map;

public class java_15898_SessionManager_A01 {
    private Map<String, String> users;

    public java_15898_SessionManager_A01() {
        users = new HashMap<>();
        users.put("admin", "password");
    }

    public String login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "Welcome, " + username;
        } else {
            return "Incorrect username or password";
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Attempt to login with incorrect credentials
        System.out.println(sessionManager.login("user", "wrong_password"));

        // Attempt to login with correct credentials
        System.out.println(sessionManager.login("admin", "password"));
    }
}