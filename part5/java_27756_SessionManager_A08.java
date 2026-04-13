public class java_27756_SessionManager_A08 {
    // Instance variable to keep track of the active sessions
    private Map<String, Session> sessions;

    // Session class that holds session information
    private class Session {
        private String userName;
        private boolean isValid;

        public java_27756_SessionManager_A08(String userName) {
            this.userName = userName;
            this.isValid = true;
        }

        public String getUserName() {
            return userName;
        }

        public boolean isValid() {
            return isValid;
        }

        public void invalidate() {
            this.isValid = false;
        }
    }

    // Constructor to initialize the sessions map
    public java_27756_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to get a session
    public Session getSession(String userName) {
        if (!sessions.containsKey(userName)) {
            sessions.put(userName, new Session(userName));
        }
        return sessions.get(userName);
    }

    // Method to close a session
    public void closeSession(String userName) {
        if (sessions.containsKey(userName)) {
            sessions.get(userName).invalidate();
        }
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String userName) {
        if (sessions.containsKey(userName)) {
            return sessions.get(userName).isValid();
        } else {
            return false;
        }
    }
}