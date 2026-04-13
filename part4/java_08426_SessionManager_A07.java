import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_08426_SessionManager_A07 {

    private List<User> users;

    public java_08426_SessionManager_A07() {
        users = new ArrayList<>();
        users.add(new User("user1", "password1", "ROLE_USER"));
        users.add(new User("user2", "password2", "ROLE_ADMIN"));
    }

    public String login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getRole();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String role = manager.login("user1", "password1");
        if (role != null) {
            System.out.println("Logged in as " + role);
        } else {
            System.out.println("Failed to log in");
        }
    }

    class User {
        private String username;
        private String password;
        private String role;

        public java_08426_SessionManager_A07(String username, String password, String role) {
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

        public String getRole() {
            return role;
        }
    }
}