public class java_17381_SessionManager_A08 {

    private static int sessionCount = 0;

    private java_17381_SessionManager_A08() {
        // Private constructor to restrict instantiation of this class
    }

    public static int getSessionCount() {
        return sessionCount;
    }

    public void openSession() {
        // Simulating the opening of a session
        sessionCount++;
        System.out.println("Session " + sessionCount + " opened.");
    }

    public void closeSession() {
        // Simulating the closing of a session
        if (sessionCount > 0) {
            sessionCount--;
            System.out.println("Session " + sessionCount + " closed.");
        } else {
            System.out.println("No active sessions.");
        }
    }

    public void runSecuritySensitiveOperation(String operation) {
        // Simulating running a security sensitive operation
        if (operation.equals("INTEGRITY_FAILURE")) {
            System.out.println("Running security sensitive operation: " + operation);
            // Adding a delay to simulate a potential integrity failure
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Operation completed successfully.");
        } else {
            System.out.println("No security sensitive operation found.");
        }
    }
}