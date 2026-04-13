import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_26766_SessionManager_A01 {
    private Map<String, User> userMap;
    private Map<String, Session> sessionMap;

    public java_26766_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public void removeUser(String userName) {
        userMap.remove(userName);
   
    }

    public void addSession(Session session) {
        sessionMap.put(session.getId(), session);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class User {
    private String name;

    public java_26766_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Session {
    private String id;

    public java_26766_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        User user1 = new User("User1");
        User user2 = new User("User2");

        Session session1 = new Session("Session1");
        Session session2 = new Session("Session2");

        sessionManager.addUser(user1);
        sessionManager.addUser(user2);

        sessionManager.addSession(session1);
        sessionManager.addSession(session2);

        // ... More code to manipulate the session manager ...
    }
}