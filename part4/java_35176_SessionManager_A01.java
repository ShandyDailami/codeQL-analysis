public class java_35176_SessionManager_A01 {
    // Simple boolean to simulate access control.
    private boolean isSessionActive = false;

    // In real applications, this would be a secure method of managing sessions.
    public void startSession() {
        isSessionActive = true;
        System.out.println("Session started.");
    }

    public void endSession() {
        isSessionActive = false;
        System.out.println("Session ended.");
    }

    // Simulate an operation that could be broken if a session is not active.
    public void performBrokenOperation(String operation) {
        if (isSessionActive) {
            System.out.println("Performing " + operation + " on session.");
        } else {
            System.out.println("Session is not active. Cannot perform operation.");
        }
    }
}