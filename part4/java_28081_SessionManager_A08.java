import java.util.ArrayList;
import java.util.List;

// User class java_28081_SessionManager_A08 User {
    private String name;

    public SessionManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// SessionManager class
public class SessionManager {
    private List<User> users;

    public SessionManager() {
        users = new ArrayList<>();
    }

    // Add user to session
    public void addUser(User user) {
        users.add(user);
    }

    // Close session
    public void closeSession() {
        // Security-sensitive operation: remove all users from session
        users.clear();
    }
}