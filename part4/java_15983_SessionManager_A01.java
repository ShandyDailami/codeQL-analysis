import java.lang.SecurityException;

public class java_15983_SessionManager_A01 {
    private boolean isSessionActive;

    // constructor
    public java_15983_SessionManager_A01() {
        isSessionActive = false;
    }

    // method to start a session
    public void startSession() throws SecurityException {
        if (!isSessionActive) {
            isSessionActive = true;
            System.out.println("Session started.");
        } else {
            throw new SecurityException("Session already active.");
        }
    }

    // method to end a session
    public void endSession() throws SecurityException {
        if (isSessionActive) {
            isSessionActive = false;
            System.out.println("Session ended.");
        } else {
            throw new SecurityException("No active session to end.");
        }
    }
}