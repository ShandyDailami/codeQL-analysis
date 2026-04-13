import java.util.HashMap;
import java.util.Map;

public class java_31372_SessionManager_A01 {
    private Map<String, User> sessionMap;

    public java_31372_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addUser(User user) {
        sessionMap.put(user.getSessionId(), user);
    }

    public void removeUser(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }
}

class User {
    private String sessionId;
    private String name;

    public java_31372_SessionManager_A01(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }
}