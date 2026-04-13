import java.util.HashMap;
import java.util.Map;

public class java_26877_SessionManager_A07 {
    private String username;
    private String password;

    public java_26877_SessionManager_A07(String username, String password) {
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

public class SessionManager {
    private Map<String, User> sessionUsers;

    public java_26877_SessionManager_A07() {
        sessionUsers = new HashMap<>();
    }

    public void startSession(User user) {
        sessionUsers.put(user.getUsername(), user);
    }

    public User getSessionUser(String username) {
        return sessionUsers.get(username);
    }

    public void endSession(String username) {
        sessionUsers.remove(username);
    }

    public boolean isSessionActive(String username) {
        return sessionUsers.containsKey(username);
    }

    public boolean authenticate(String username, String password) {
        User user = sessionUsers.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}