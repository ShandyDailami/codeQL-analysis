import java.util.HashMap;
import java.util.Map;

public class java_20851_SessionManager_A07 {
    private Map<String, SessionContext> sessions;
    private Map<String, Authentication> authentications;

    public java_20851_SessionManager_A07() {
        sessions = new HashMap<>();
        authentications = new HashMap<>();
    }

    public void addAuthentication(String username, String password) {
        authentications.put(username, new Authentication(username, password));
    }

    public SessionContext startSession(String username) throws AuthFailureException {
        Authentication auth = authentications.get(username);
        if (auth == null) {
            throw new AuthFailureException("Authentication failed");
        }

        if (!auth.isValid()) {
            throw new AuthFailureException("Authentication failed");
        }

        SessionContext session = new SessionContext(username);
        sessions.put(session.getId(), session);
        return session;
    }

    public SessionContext getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class SessionContext {
        private String id;
        private String username;

        public java_20851_SessionManager_A07(String username) {
            this.username = username;
            this.id = username + System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }
    }

    public class Authentication {
        private String username;
        private String password;

        public java_20851_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean isValid() {
            // Add authentication logic here to check if username and password are valid
            // For now, we just return true
            return true;
        }
    }

    public class AuthFailureException extends Exception {
        public java_20851_SessionManager_A07(String message) {
            super(message);
        }
    }
}