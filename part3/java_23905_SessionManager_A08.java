public class java_23905_SessionManager_A08 {

    private int sessionCount = 0;
    private static SessionManager instance = null;

    private java_23905_SessionManager_A08() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public int createSession() {
        sessionCount++;
        return sessionCount;
    }

    public void closeSession(int sessionId) {
        if (sessionId <= sessionCount) {
            sessionCount--;
        } else {
            System.out.println("Invalid session ID: " + sessionId);
        }
    }

    public void closeAllSessions() {
        sessionCount = 0;
    }

}