public class java_37644_SessionManager_A08 {
    private static int currentSessionId = 0;
    private static HashMap<Integer, Session> sessions = new HashMap<>();

    public static class Session {
        private int id;
        private boolean isOpen = false;
        private byte[] data;

        public java_37644_SessionManager_A08(byte[] data) {
            this.id = currentSessionId++;
            this.data = data;
        }

        public byte[] getData() {
            return data;
        }

        public void close() {
            isOpen = false;
        }

        public boolean isOpen() {
            return isOpen;
        }
    }

    public Session openSession(byte[] data) {
        if (sessions.size() == 10) {
            throw new RuntimeException("All sessions are open.");
        }
        Session session = new Session(data);
        sessions.put(session.id, session);
        return session;
    }

    public void closeSession(Session session) {
        session.close();
    }

    public byte[] getData(Session session) {
        if (!session.isOpen()) {
            throw new RuntimeException("Session not open.");
        }
        return session.getData();
    }
}