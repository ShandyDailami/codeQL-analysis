public class java_02142_SessionManager_A01 {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start session
        sessionManager.startSession();

        // Perform security-sensitive operations
        sessionManager.accessSystem();

        // Close session
        sessionManager.closeSession();
    }
}

class SessionManager {
    private boolean isSessionActive;

    public void startSession() {
        System.out.println("Session started.");
        isSessionActive = true;
    }

    public void accessSystem() {
        if (isSessionActive) {
            System.out.println("Accessing system...");
            // perform security-sensitive operations
            // here, we just print a message to demonstrate
            System.out.println("System accessed successfully.");
        } else {
            System.out.println("Error: Session not active.");
        }
    }

    public void closeSession() {
        System.out.println("Session closed.");
        isSessionActive = false;
    }
}