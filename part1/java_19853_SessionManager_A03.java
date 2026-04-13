public class java_19853_SessionManager_A03 {
    private Session[] sessions;
    private int currentIndex;

    public java_19853_SessionManager_A03(int size) {
        sessions = new Session[size];
        currentIndex = 0;
    }

    public void createSession(String sessionId) {
        if (currentIndex < sessions.length) {
            sessions[currentIndex] = new Session(sessionId);
            currentIndex++;
        } else {
            System.out.println("No more space for sessions");
        }
    }

    public Session getSession(String sessionId) {
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i].getId().equals(sessionId)) {
                return sessions[i];
            }
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i].getId().equals(sessionId)) {
                sessions[i] = null;
                return;
            }
        }
        System.out.println("Session not found");
    }

    public static class Session {
        private String id;

        public java_19853_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}