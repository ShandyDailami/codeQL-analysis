public class java_18805_SessionManager_A01 {
    private static SessionManager instance;
    private java_18805_SessionManager_A01() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Map<String, Session> sessionMap = new HashMap<>();

    public Session createSession(String userName) {
        Session session = sessionMap.get(userName);
        if (session == null) {
            session = createNewSession(userName);
            sessionMap.put(userName, session);
        }
        return session;
    }

    private Session createNewSession(String userName) {
        // Create a new session here, for instance, based on user's authentication
        // For demonstration purposes, let's return a fake session
        return new Session(userName);
    }

    public void endSession(String userName) {
        Session session = sessionMap.get(userName);
        if (session != null) {
            sessionMap.remove(userName);
        }
    }
}

class Session {
    private String userName;

    public java_18805_SessionManager_A01(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}