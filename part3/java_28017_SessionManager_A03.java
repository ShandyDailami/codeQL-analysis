import java.util.HashMap;
import java.util.Map;

public class java_28017_SessionManager_A03 {
    private Map<String, User> sessionMap;

    public java_28017_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = user.getUserId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public User getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        User user = new User("1", "John Doe", "john@example.com");
        String sessionId = manager.createSession(user);

        User retrievedUser = manager.getSession(sessionId);
        System.out.println("User retrieved from session: " + retrievedUser);

        manager.closeSession(sessionId);
    }
}

class User {
    private String userId;
    private String name;
    private String email;

    public java_28017_SessionManager_A03(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}