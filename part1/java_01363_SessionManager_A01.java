public class java_01363_SessionManager_A01 {
    private static int currentSessionId = 0;

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Test session creation
        sessionManager.startSession();
        sessionManager.startSession(1); // Should throw exception

        // Test session management
        sessionManager.manageSession(1); // Should be allowed
        sessionManager.manageSession(0); // Should throw exception

        // Test session destruction
        sessionManager.destroySession(1); // Should be allowed
        sessionManager.destroySession(0); // Should throw exception
    }

    public void startSession() {
        if (currentSessionId > 0) {
            throw new IllegalStateException("Cannot start session with ID " + currentSessionId);
        }
        currentSessionId++;
        System.out.println("Started session with ID " + currentSessionId);
    }

    public void manageSession(int sessionId) {
        if (sessionId <= 0 || sessionId != currentSessionId) {
            throw new IllegalStateException("Cannot manage session with ID " + sessionId);
        }
        System.out.println("Managed session with ID " + sessionId);
    }

    public void destroySession(int sessionId) {
        if (sessionId <= 0 || sessionId != currentSessionId) {
            throw new IllegalStateException("Cannot destroy session with ID " + sessionId);
        }
        currentSessionId--;
        System.out.println("Destroyed session with ID " + sessionId);
    }
}