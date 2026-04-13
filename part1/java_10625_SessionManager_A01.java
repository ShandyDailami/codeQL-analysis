public class java_10625_SessionManager_A01 {
    private int id;
    private String name;

    public java_10625_SessionManager_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters
}

public class Session {
    private User user;
    private int userId;

    public java_10625_SessionManager_A01(User user, int userId) {
        this.user = user;
        this.userId = userId;
    }

    // getters and setters
}

public class SessionManager {
    private HashMap<Integer, Session> sessions;

    public java_10625_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.put(session.getUser().getId(), session);
    }

    public Session getSession(int userId) {
        return sessions.get(userId);
    }

    public void removeSession(int userId) {
        sessions.remove(userId);
    }

    // other operations related to sessions
}