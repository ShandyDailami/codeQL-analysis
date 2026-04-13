import java.util.HashMap;
import java.util.Map;

public class java_20559_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_20559_SessionManager_A08() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean validateUser(String username, String password) {
        String correctPassword = getPassword(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_20559_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean login(String username, String password) {
        if (securityManager.validateUser(username, password)) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);

        // Testing the login system
        sessionManager.login("user1", "password1"); // Should print "Login successful"
        sessionManager.login("user1", "wrongPassword"); // Should print "Invalid username or password"
        sessionManager.login("wrongUser", "wrongPassword"); // Should print "Invalid username or password"
    }
}