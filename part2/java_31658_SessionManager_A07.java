import java.util.HashMap;
import java.util.Map;

public class java_31658_SessionManager_A07 {
    private Map<String, User> userMap;

    public java_31658_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public User login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        // Simulate database query by creating a User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Verify the user's credentials
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            userMap.put(username, user);
            return user;
        } else {
            return null;
        }
    }

    public User getUser(String username) {
        return userMap.get(username);
    }

    public void logout(String username) {
        userMap.remove(username);
    }

    // User class
    public static class User {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}