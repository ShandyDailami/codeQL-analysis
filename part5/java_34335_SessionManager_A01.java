import java.util.HashMap;
import java.util.Map;

public class java_34335_SessionManager_A01 {
    private Map<String, String> users = new HashMap<>();

    public java_34335_SessionManager_A01() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public String getPassword(String username) {
        return users.get(username);
    }

    public boolean validateUser(String username, String password) {
        String correctPassword = users.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_34335_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean validateUser(String username, String password) {
        if (!securityManager.validateUser(username, password)) {
            System.out.println("Invalid username or password");
            return false;
        }
        System.out.println("Access granted");
        return true;
    }
}