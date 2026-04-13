public class java_29842_SessionManager_A01 {
    private static int currentSessionId = 0;
    private static Session[] sessions = new Session[100];

    public static class Session {
        private int sessionId;

        public java_29842_SessionManager_A01() {
            this.sessionId = ++currentSessionId;
        }

        public int getSessionId() {
            return this.sessionId;
        }

        public void closeSession() {
            // Here we simulate the closing of a session by printing a message
            System.out.println("Closing session with ID: " + this.sessionId);
        }
    }

    public static Session openSession() {
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == null) {
                sessions[i] = new Session();
                System.out.println("Opened session with ID: " + sessions[i].getSessionId());
                return sessions[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Session session = openSession();
        session.closeSession();
    }
}