import java.util.HashMap;
import java.util.Map;

public class java_07340_SessionManager_A03 {
    private static Map<String, User> userMap = new HashMap<>();
    private static Map<String, Session> sessionMap = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        Session session1 = new Session(user1);
        Session session2 = new Session(user2);

        userMap.put(user1.getName(), user1);
        userMap.put(user2.getName(), user2);

        sessionMap.put(session1.getId(), session1);
        sessionMap.put(session2.getId(), session2);

        // Retrieve the session and user
        Session retrievedSession = sessionMap.get(session1.getId());
        User retrievedUser = userMap.get(session1.getUserName());

        System.out.println("Retrieved session: " + retrievedSession.getId());
        System.out.println("Retrieved user: " + retrievedUser.getName());
    }
}

class User {
    private String name;
    private String password;

    public java_07340_SessionManager_A03(String name, String password) {
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

class Session {
    private String id;
    private User user;

    public java_07340_SessionManager_A03(User user) {
        this.id = user.getName() + "_session";
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return user.getName();
    }
}