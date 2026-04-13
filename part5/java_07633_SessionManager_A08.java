public class java_07633_SessionManager_A08 {
    private String id;
    private User user;

    public java_07633_SessionManager_A08(String id, User user) {
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

    public java_07633_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class SessionManager {
    private List<Session> sessions = new LinkedList<>();

    public Session createSession(User user) {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id, user);
        sessions.add(session);
        return session;
    }

    public Session getSession(String id) {
        for (Session session : sessions) {
            if (session.getId().equals(id)) {
                return session;
            }
        }
        return null;
    }

    public void removeSession(String id) {
        sessions.removeIf(session -> session.getId().equals(id));
    }
}