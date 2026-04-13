import java.util.HashMap;
import java.util.Map;

public class java_32722_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_32722_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        String storedPassword = userMap.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}

public class SecurityTest {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // User 1 logs in with correct credentials
        if (sessionManager.isValidUser("user1", "password1")) {
            System.out.println("User 1 is logged in successfully!");
        } else {
            System.out.println("Invalid credentials for user 1!");
        }

        // User 2 logs in with incorrect credentials
        if (!sessionManager.isValidUser("user2", "wrongpassword")) {
            System.out.println("User 2 is logged in successfully!");
        } else {
            System.out.println("Invalid credentials for user 2!");
        }
    }
}