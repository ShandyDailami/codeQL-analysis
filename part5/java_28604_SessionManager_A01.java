import java.util.ArrayList;
import java.util.List;

public class java_28604_SessionManager_A01 {
    private List<User> users = new ArrayList<>();
    private int limit;

    public java_28604_SessionManager_A01(int limit) {
        this.limit = limit;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public boolean isAccessible() {
        return users.size() < limit;
    }

    public static void main(String[] args) {
        // Create a session with a limit of 2 users
        Session session = new Session(2);

        // Create users
        User user1 = new User("User 1");
        User user2 = new User("User 2");

        // Add users to the session
        session.addUser(user1);
        session.addUser(user2);

        // Check if the session is accessible
        System.out.println("Session is accessible: " + session.isAccessible());

        // Try to add a third user
        User user3 = new User("User 3");
        session.addUser(user3);

        // Check if the session is now accessible
        System.out.println("Session is accessible after adding user 3: " + session.isAccessible());
    }
}

class User {
    private String name;

    public java_28604_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}