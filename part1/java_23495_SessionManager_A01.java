public class java_23495_SessionManager_A01 {

    // A session is a logical unit of work.
    private class Session {
        private boolean isActive = false;
        private int accessCount = 0;

        public void open() {
            isActive = true;
        }

        public void close() {
            isActive = false;
        }

        public void access() {
            if (isActive) {
                accessCount++;
            } else {
                System.out.println("Session is closed. Can't access session.");
            }
        }

        public void printAccessCount() {
            System.out.println("Access count: " + accessCount);
        }
    }

    // A manager manages multiple sessions.
    private Session[] sessions = new Session[10];
    private int activeSessionsCount = 0;

    public void openSession() {
        if (activeSessionsCount < sessions.length) {
            sessions[activeSessionsCount] = new Session();
            sessions[activeSessionsCount].open();
            activeSessionsCount++;
        } else {
            System.out.println("All sessions are already open.");
        }
    }

    public void closeSession(int sessionId) {
        if (sessionId >= 0 && sessionId < activeSessionsCount) {
            sessions[sessionId].close();
            activeSessionsCount--;
        } else {
            System.out.println("Invalid session ID.");
        }
    }

    public void accessSession(int sessionId) {
        if (sessionId >= 0 && sessionId < activeSessionsCount) {
            sessions[sessionId].access();
        } else {
            System.out.println("Invalid session ID.");
        }
    }

    public void printAccessCount(int sessionId) {
        if (sessionId >= 0 && sessionId < activeSessionsCount) {
            sessions[sessionId].printAccessCount();
        } else {
            System.out.println("Invalid session ID.");
        }
    }
}