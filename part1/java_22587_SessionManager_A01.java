import java.util.HashMap;
import java.util.Map;

public class java_22587_SessionManager_A01 {

    private Map<User, String> sessionMap;

    public java_22587_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSession(User user) {
        return sessionMap.get(user);
    }

    public void createSession(User user, String sessionId) {
        sessionMap.put(user, sessionId);
    }

    public void endSession(User user) {
        sessionMap.remove(user);
    }

    public boolean isSessionValid(User user, String sessionId) {
        if (sessionMap.containsKey(user)) {
            return sessionMap.get(user).equals(sessionId);
        } else {
            return false;
        }
    }
}

public class User {

    private String username;

    public java_22587_SessionManager_A01(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}