import java.util.HashMap;
import java.util.Map;

public class java_08723_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_08723_SessionManager_A01() {
        this.userMap = new HashMap<>();
        userMap.put("admin", "admin");
        userMap.put("user", "user");
    }

    public String validateUser(String user, String password) {
        String expectedPassword = userMap.get(user);
        if (expectedPassword == null) {
            return "Invalid user";
        }
        if (!expectedPassword.equals(password)) {
            return "Invalid password";
        }
        return "Success";
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_08723_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String login(String user, String password) {
        return securityManager.validateUser(user, password);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);
        System.out.println(sessionManager.login("admin", "admin"));
        System.out.println(sessionManager.login("user", "user"));
        System.out.println(sessionManager.login("admin", "wrong"));
    }
}