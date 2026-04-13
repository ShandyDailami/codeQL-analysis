public class java_21020_SessionManager_A01 {
    private static int sessionCount = 0;

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession();
        sessionManager.startSession();
        sessionManager.stopSession();
    }

    public void startSession() {
        if (sessionCount == 0) {
            System.out.println("Starting session " + (sessionCount + 1));
            SessionImpl sessionImpl = new SessionImpl();
            sessionImpl.open();
        } else {
            System.out.println("Starting session " + (sessionCount + 1));
        }
        sessionCount++;
    }

    public void stopSession() {
        if (sessionCount > 0) {
            System.out.println("Stopping session " + sessionCount);
            sessionCount--;
        } else {
            System.out.println("No active session to stop");
        }
    }

    static class SessionImpl {
        private boolean isOpen = false;

        public void open() {
            if (!isOpen) {
                System.out.println("Opening session");
                isOpen = true;
            } else {
                System.out.println("Session already open");
            }
        }

        public void close() {
            if (isOpen) {
                System.out.println("Closing session");
                isOpen = false;
            } else {
                System.out.println("Session already closed");
            }
        }
    }
}