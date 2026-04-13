import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_02922_SessionManager_A01 {
    // Map to hold session objects
    private Map<String, Session> sessions = new HashMap<>();
    // List to hold user objects
    private List<User> users = new ArrayList<>();

    // Session class
    public class Session {
        private User user;

        public java_02922_SessionManager_A01(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    // User class
    public class User {
        private String name;

        public java_02922_SessionManager_A01(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Method to create a new session
    public Session createSession(String userName) {
        User user = new User(userName);
        Session session = new Session(user);
        sessions.put(user.getName(), session);
        users.add(user);
        return session;
    }

    // Method to close an existing session
    public void closeSession(String userName) {
        User user = getUser(userName);
        if (user != null) {
            sessions.remove(user.getName());
            users.remove(user);
        }
    }

    // Method to get a user by name
    private User getUser(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}