public class java_19453_SessionManager_A07 {
    private static SessionManager instance = null;
    private static Object lock = new Object();
    private static int MAX_SESSIONS = 10;
    private List<Session> activeSessions = new ArrayList<>();

    private java_19453_SessionManager_A07() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }

    public Session startSession(User user) {
        if (activeSessions.size() >= MAX_SESSIONS) {
            throw new AuthFailureException("All sessions are full");
        }
        Session session = new Session(user);
        activeSessions.add(session);
        return session;
    }

    public void endSession(Session session) {
        activeSessions.remove(session);
    }

    public Session getSession(String sessionId) {
        for (Session session : activeSessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        throw new AuthFailureException("Invalid session");
    }
}

class Session {
    private User user;
    private String id;

    public java_19453_SessionManager_A07(User user) {
        this.user = user;
        this.id = UUID.randomUUID().toString(); // Generate a random UUID for the session id
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }
}

class User {
    private String username;
    private String password;

    public java_19453_SessionManager_A07(String username, String password) {
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

class AuthFailureException extends RuntimeException {
    public java_19453_SessionManager_A07(String message) {
        super(message);
    }
}