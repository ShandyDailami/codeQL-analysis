import java.util.HashMap;
import java.util.Map;

public class java_30083_SessionManager_A08 {
    // A simple user class
    public static class User {
        private String name;
        private String password;

        public java_30083_SessionManager_A08(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    // A simple map to hold users
    private Map<String, User> userMap;

    // Constructor
    public java_30083_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    // Method to add a user to the map
    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    // Method to retrieve a user from the map
    public User getUser(String name) {
        return userMap.get(name);
    }

    public static void main(String[] args) {
        // Create a session manager
        SessionManager sessionManager = new SessionManager();

        // Create a user
        User user = new SessionManager.User("Alice", "password");

        // Add the user to the session manager
        sessionManager.addUser(user);

        // Retrieve the user from the session manager
        User retrievedUser = sessionManager.getUser("Alice");

        // Print out the retrieved user's password
        System.out.println("Retrieved user's password: " + retrievedUser.getPassword());
    }
}