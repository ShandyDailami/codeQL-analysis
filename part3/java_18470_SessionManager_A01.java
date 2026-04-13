public class java_18470_SessionManager_A01 {

    private static SessionManager instance;

    private java_18470_SessionManager_A01() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String username) {
        if (!checkAccessControl(username)) {
            throw new SecurityException("Access Denied for user: " + username);
        }

        Session session = new Session();
        session.setUsername(username);
        sessions.put(username, session);
        return session;
    }

    public void closeSession(String username) {
        if (!checkAccessControl(username)) {
            throw new SecurityException("Access Denied for user: " + username);
        }

        sessions.remove(username);
    }

    private boolean checkAccessControl(String username) {
        // Here goes the access control logic
        // For example, a simple check if the username is in a predefined list of allowed users
        List<String> allowedUsers = new ArrayList<>();
        // Add your allowed users here

        return allowedUsers.contains(username);
    }
}