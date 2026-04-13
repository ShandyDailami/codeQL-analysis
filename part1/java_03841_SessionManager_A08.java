import java.util.HashMap;
import java.util.Map;

public class java_03841_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_03841_SessionManager_A08() {
        userMap = new HashMap<>();
        userMap.put("admin", "password");
        userMap.put("user", "password");
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return "Welcome, " + username;
        } else {
            throw new SecurityFailureException("Invalid credentials");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        try {
            System.out.println(securityManager.authenticate("admin", "password"));
            System.out.println(securityManager.authenticate("user", "wrong_password"));
        } catch (SecurityFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}