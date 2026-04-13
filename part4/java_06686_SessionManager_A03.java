import java.util.*;

class java_06686_SessionManager_A03 {
    private String name;
    private String password;

    public Main(String name, String password) {
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

class SessionManager {
    private Map<String, User> sessions;

    public Main() {
        sessions = new HashMap<>();
    }

    public void addUser(User user) {
        sessions.put(user.getName(), user);
    }

    public User getUser(String name) {
        return sessions.get(name);
    }

    public void deleteUser(String name) {
        sessions.remove(name);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.addUser(new User("user1", "password1"));
        manager.addUser(new User("user2", "password2"));

        User user = manager.getUser("user1");
        if (user != null && user.getPassword().equals("password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied");
        }

        manager.deleteUser("user2");
        user = manager.getUser("user2");
        if (user == null) {
            System.out.println("User2 deleted successfully");
        } else {
            System.out.println("User2 is still present");
        }
    }
}