import java.util.ArrayList;
import java.util.List;

public class java_24554_SessionManager_A08 {

    private List<User> activeSessions;

    public java_24554_SessionManager_A08() {
        activeSessions = new ArrayList<>();
    }

    public void addUserSession(User user) {
        activeSessions.add(user);
    }

    public void removeUserSession(User user) {
        activeSessions.remove(user);
    }

    public boolean isSessionActive(User user) {
        return activeSessions.contains(user);
    }

    private class User {

        private String username;
        private String password;

        public java_24554_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        private String hashPassword(String password) {
            // Implement a secure hashing mechanism here
            // For this example, we will just return a hash of the password
            return Integer.toString(password.hashCode());
        }
    }
}