import java.util.HashMap;

public class java_34835_SessionManager_A01 {
    // Define a HashMap to store session id and user objects
    private HashMap<String, User> sessions = new HashMap<>();

    // Define a User class
    public class User {
        private String username;
        private String password;

        public java_34835_SessionManager_A01(String username, String password) {
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

    // Define a method to login
    public User login(String username, String password) {
        // This is a dummy login, in reality you would need to authenticate against a database
        // If the password is incorrect, return null
        if ("admin".equals(username) && "password".equals(password)) {
            return new User(username, password);
        } else {
            return null;
        }
    }

    // Define a method to logout
    public void logout(String sessionId) {
        // Remove the session from the map
        sessions.remove(sessionId);
    }

    // Define a method to get the user from a session
    public User getUserFromSession(String sessionId) {
        // This is a dummy method, in reality you would need to get the user from a database
        // For now we just return the user from the session id
        return sessions.get(sessionId);
    }
}