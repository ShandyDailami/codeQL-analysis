import java.util.HashMap;

public class java_02690_SessionManager_A01 {
    private HashMap<String, User> sessionMap;

    public java_02690_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    public User getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.createSession("session1", new User("User1", "password1"));
        sm.createSession("session2", new User("User2", "password2"));

        User user = sm.getUserFromSession("session1");
        System.out.println("User from session 1: " + user.getName());

        user = sm.getUserFromSession("session2");
        System.out.println("User from session 2: " + user.getName());

        sm.deleteSession("session1");
        sm.deleteSession("session2");
    }
}

class User {
    private String name;
    private String password;

    public java_02690_SessionManager_A01(String name, String password) {
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