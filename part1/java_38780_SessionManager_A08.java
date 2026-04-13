import java.util.HashMap;
import java.util.Map;

public class java_38780_SessionManager_A08 {
    private Map<String, User> sessions;

    public java_38780_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void addSession(User user) {
        sessions.put(user.getName(), user);
    }

    public User getSession(String username) {
        return sessions.get(username);
    }

    public void removeSession(String username) {
        sessions.remove(username);
    }
}

public class User {
    private String name;
    private String password;

    public java_38780_SessionManager_A08(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}