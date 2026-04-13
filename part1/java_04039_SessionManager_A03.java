import java.util.HashMap;
import java.util.Map;

public class java_04039_SessionManager_A03 {

    private Map<String, User> sessionMap;

    public java_04039_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String sessionId(User user) {
        String sessionId = user.hashCode() + "";
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public User getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class User {
    private String name;

    public java_04039_SessionManager_A03(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}