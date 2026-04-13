public class java_40992_SessionManager_A01 {

    // This is a simple array that simulates a database.
    private Session[] sessions = new Session[10];

    // This is a simple class that simulates a session.
    private static class Session {
        boolean isActive = false;
    }

    public void openSession() {
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == null || !sessions[i].isActive) {
                sessions[i] = new Session();
                System.out.println("Opened session " + i);
                return;
            }
        }
        System.out.println("All sessions are open");
    }

    public void closeSession(int sessionId) {
        if (sessions[sessionId] != null && sessions[sessionId].isActive) {
            sessions[sessionId].isActive = false;
            System.out.println("Closed session " + sessionId);
        } else {
            System.out.println("Session " + sessionId + " is already closed or does not exist");
        }
    }

    public void checkSession(int sessionId) {
        if (sessions[sessionId] != null && sessions[sessionId].isActive) {
            System.out.println("Session " + sessionId + " is active");
        } else {
            System.out.println("Session " + sessionId + " is not active");
        }
    }
}