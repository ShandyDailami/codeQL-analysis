public class java_17753_SessionManager_A08 {
    private int currentSessionId;

    public Session startSession() {
        currentSessionId++;
        return new Session(currentSessionId);
    }

    public void endSession(Session session) {
        if (session.getId() == currentSessionId) {
            currentSessionId--;
        } else {
            throw new IllegalStateException("Invalid session");
        }
    }

    private static class Session {
        private final int id;

        Session(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}