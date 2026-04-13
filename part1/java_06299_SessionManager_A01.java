public class java_06299_SessionManager_A01 {
    private String id;
    private User user;

    public java_06299_SessionManager_A01(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}

public class User {
    private String name;

    public java_06299_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class SessionManager {
    private List<Session> sessions;

    public java_06299_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public void addSession(String id, String userName) {
        User user = new User(userName);
        Session session = new Session(id, user);
        sessions.add(session);
    }

    public User getUserBySessionId(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session.getUser();
            }
        }
        return null;
    }
}