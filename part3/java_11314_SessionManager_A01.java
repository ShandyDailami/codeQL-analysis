public class java_11314_SessionManager_A01 {
    private int sessionCount = 0;
    private static final int MAX_SESSIONS = 5;

    public class Session {
        private String sessionId;
        private boolean isActive = false;

        public java_11314_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void startSession() {
            if (sessionCount < MAX_SESSIONS) {
                isActive = true;
                sessionCount++;
            } else {
                System.out.println("Maximum sessions reached.");
            }
        }

        public void endSession() {
            if (isActive) {
                isActive = false;
                sessionCount--;
            } else {
                System.out.println("No active session to end.");
            }
        }
    }

    private Session[] sessions = new Session[MAX_SESSIONS];
    private int activeSessions = 0;

    public void startSession(String sessionId) {
        for (int i = 0; i < MAX_SESSIONS; i++) {
            if (sessions[i] == null || !sessions[i].isActive()) {
                sessions[i] = new Session(sessionId);
                sessions[i].startSession();
                activeSessions++;
                break;
            }
        }
    }

    public void endSession(String sessionId) {
        for (int i = 0; i < MAX_SESSIONS; i++) {
            if (sessions[i] != null && sessions[i].isActive() && sessionId.equals(sessions[i].getSessionId())) {
                sessions[i].endSession();
                activeSessions--;
                sessions[i] = null;
                break;
            }
        }
    }

    public static void main(String[] args) {
        SecurityExample example = new SecurityExample();

        example.startSession("Session1");
        example.startSession("Session2");
        example.startSession("Session3");
        example.startSession("Session4");
        example.startSession("Session5");

        example.endSession("Session2");
        example.endSession("Session4");
        example.endSession("Session5");

        example.startSession("Session6");
    }
}