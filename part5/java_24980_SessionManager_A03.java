public class java_24980_SessionManager_A03 {
    private static HashMap<String, Session> sessions = new HashMap<>();

    public static Session getSession(String username) {
        Session session = sessions.get(username);
        if (session == null) {
            session = createSession(username);
            sessions.put(username, session);
        }
        return session;
    }

    private static Session createSession(String username) {
        // This is a placeholder for a more complex session creation logic.
        // For example, you may want to connect to a database, handle connections, etc.
        return new Session(username);
    }

    public static void closeSession(String username) {
        Session session = sessions.get(username);
        if (session != null) {
            session.close();
            sessions.remove(username);
        }
    }

    public static class Session {
        private String username;

        public java_24980_SessionManager_A03(String username) {
            this.username = username;
            // This is a placeholder for a more complex session logic.
            // For example, you may want to connect to a database, handle connections, etc.
        }

        public void close() {
            // This is a placeholder for a more complex session logic.
            // For example, you may want to disconnect from a database, handle connections, etc.
        }
    }
}