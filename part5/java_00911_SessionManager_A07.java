import java.util.HashMap;

public class java_00911_SessionManager_A07 {
    private HashMap<String, User> sessions;

    public java_00911_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }

    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class User {
    private String username;
    private String password;

    public java_00911_SessionManager_A07(String username, String password) {
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

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        sessionManager.addSession("session1", user1);
        sessionManager.addSession("session2", user2);

        User retrievedUser = sessionManager.getUser("session1");
        System.out.println(retrievedUser.getUsername());

        sessionManager.removeSession("session1");

        retrievedUser = sessionManager.getUser("session1");
        System.out.println(retrievedUser); // Output: null
    }
}