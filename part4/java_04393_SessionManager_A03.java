import java.util.HashMap;

public class java_04393_SessionManager_A03 {
    // Using a HashMap to simulate a database
    private HashMap<String, User> users;

    // Create a SessionManager
    public java_04393_SessionManager_A03() {
        users = new HashMap<String, User>();
    }

    // Add a new User
    public void addUser(String username, String password) {
        User newUser = new User(username, password);
        users.put(username, newUser);
    }

    // Authenticate a User
    public boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class
    private class User {
        private String username;
        private String password;

        public java_04393_SessionManager_A03(String username, String password) {
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
}