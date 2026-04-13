public class java_32159_SessionManager_A08 {
    private static SessionManager instance;

    private java_32159_SessionManager_A08() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String userName) {
        if (sessions.containsKey(userName)) {
            return sessions.get(userName);
        }

        Session session = new Session(userName);
        sessions.put(userName, session);
        return session;
    }

    private class Session {
        private String userName;

        public java_32159_SessionManager_A08(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            if (!userName.equals(this.userName)) {
                // This is a security operation, it's not recommended to change the user name
                throw new SecurityException("Attempt to change user name");
            }

            this.userName = userName;
        }
    }
}