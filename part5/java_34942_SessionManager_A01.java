import java.util.HashMap;
import java.util.Map;

public class java_34942_SessionManager_A01 {
    private Map<String, User> sessions;

    public java_34942_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }

    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void updateUser(String sessionId, User updatedUser) {
        sessions.put(sessionId, updatedUser);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class User {
    private String name;
    private String password;

    public java_34942_SessionManager_A01(String name, String password) {
        this.name = name;
        this.password = password; // It's not recommended to store passwords in plain text in real applications.
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}