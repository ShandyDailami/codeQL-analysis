import java.util.HashMap;
import java.util.Map;

public class java_06963_SessionManager_A07 {
    // Mock user database
    private Map<String, User> users = new HashMap<>();

    public java_06963_SessionManager_A07() {
        users.put("user1", new User("user1", "password1", User.Role.ADMIN));
        users.put("user2", new User("user2", "password2", User.Role.USER));
        users.put("user3", new User("user3", "password3", User.Role.USER));
    }

    // Authenticate a user
    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Check if a user is authenticated
    public boolean isAuthenticated(String username) {
        return users.containsKey(username);
    }

    // Check if a user is authorized
    public boolean isAuthorized(String username, User.Role role) {
        User user = users.get(username);
        return user != null && user.getRole().equals(role);
    }

    // User class
    public static class User {
        public static enum Role { ADMIN, USER }

        private String username;
        private String password;
        private Role role;

        public java_06963_SessionManager_A07(String username, String password, Role role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Role getRole() {
            return role;
        }
    }
}