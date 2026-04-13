public class java_37137_SessionManager_A08 {
    private int sessionCount;

    public java_37137_SessionManager_A08() {
        sessionCount = 0;
    }

    public void startSession() throws Exception {
        if (sessionCount == 0) {
            sessionCount = 1;
            System.out.println("Session started");
        } else {
            throw new Exception("Maximum session limit reached");
        }
    }

    public void endSession() {
        if (sessionCount > 0) {
            sessionCount--;
            System.out.println("Session ended");
        } else {
            System.out.println("No active session");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        try {
            manager.startSession();
            manager.startSession();
            manager.endSession();
            manager.endSession();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}