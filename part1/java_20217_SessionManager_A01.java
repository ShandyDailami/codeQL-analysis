import java.util.HashMap;
import java.util.Map;

public class java_20217_SessionManager_A01 {
    private String username;
    private String password;

    public java_20217_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class SessionManager {
    private Map<String, User> users = new HashMap<>();

    public java_20217_SessionManager_A01() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

public class BrokenAccessControl {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Attempt to access the database with a user that does not exist
        User user = sessionManager.getUser("unknownUser");

        if (user == null) {
            System.out.println("Access denied for user unknownUser");
        } else {
            System.out.println("Access granted for user " + user.getUsername());
        }
    }
}