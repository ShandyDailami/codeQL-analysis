import java.util.ArrayList;
import java.util.List;

public class java_13409_SessionManager_A07 {
    // private static instance of SessionManager
    private static SessionManager sessionManager;

    // private constructor to prevent instantiation
    private java_13409_SessionManager_A07() { }

    // public static method to get instance of SessionManager
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // private List to store active users
    private List<User> activeUsers = new ArrayList<>();

    // public method to authenticate a user
    public boolean authenticate(String username, String password) {
        // Here, you can add your own logic for authentication.
        // For the sake of simplicity, we'll assume a successful authentication
        return true;
    }

    // public method to logout a user
    public void logout(User user) {
        activeUsers.remove(user);
    }

    // public method to check if a user is authenticated
    public boolean isUserAuthenticated(User user) {
        return activeUsers.contains(user);
    }

    // private static class to represent a user
    private static class User {
        private String username;
        private String password;

        public java_13409_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Override equals and hashCode methods to use in collections
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (!username.equals(user.username)) return false;
            return password.equals(user.password);
        }

        @Override
        public int hashCode() {
            int result = username.hashCode();
            result = 31 * result + password.hashCode();
            return result;
        }
    }
}