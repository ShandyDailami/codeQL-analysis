public class java_31097_SessionManager_A01 {
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public boolean isAuthorized(String username, String password) {
        return username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD);
    }

    public Session createSession() {
        return new Session();
    }

    public void closeSession(Session session) {
        // No need to implement this method since we don't use a database here
    }
}

public class Session {
    private boolean isClosed = false;

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
}

public class Main {
    private static SessionManager sessionManager = new SessionManager();

    public static void main(String[] args) {
        Session session = sessionManager.createSession();
        if (sessionManager.isAuthorized("admin", "password")) {
            System.out.println("Session created.");
            sessionManager.closeSession(session);
        } else {
            System.out.println("Access denied.");
        }
    }
}