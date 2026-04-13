import java.util.*;

public class java_18054_SessionManager_A07 {
    // Define a session map
    private Map<String, Session> sessionMap;

    // Define a session class
    public class Session {
        private String userName;
        private boolean loggedIn;

        // Constructor
        public java_18054_SessionManager_A07(String userName) {
            this.userName = userName;
            this.loggedIn = false;
        }

        // Methods
        public void login(String password) {
            // This method is a placeholder. Replace it with actual implementation.
            if (password.equals("password")) {
                loggedIn = true;
            } else {
                throw new AuthFailureException();
            }
        }

        public void logout() {
            loggedIn = false;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public String getUserName() {
            return userName;
        }
    }

    // Constructor
    public java_18054_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Methods
    public Session createSession(String userName) {
        Session session = new Session(userName);
        sessionMap.put(userName, session);
        return session;
    }

    public Session getSession(String userName) {
        if (sessionMap.containsKey(userName)) {
            return sessionMap.get(userName);
        } else {
            throw new NoSuchSessionException();
        }
    }

    public void deleteSession(String userName) {
        if (sessionMap.containsKey(userName)) {
            sessionMap.get(userName).logout();
            sessionMap.remove(userName);
        } else {
            throw new NoSuchSessionException();
        }
    }

    // Exception classes
    public class NoSuchSessionException extends RuntimeException {
        public java_18054_SessionManager_A07() {
            super("No such session exception");
        }
    }

    public class AuthFailureException extends RuntimeException {
        public java_18054_SessionManager_A07() {
            super("Authentication failed exception");
        }
    }
}