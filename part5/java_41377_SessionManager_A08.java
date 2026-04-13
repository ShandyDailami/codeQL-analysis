public class java_41377_SessionManager_A08 {

    private static int sessionCounter = 0;

    private int sessionId;

    public java_41377_SessionManager_A08() {
        sessionCounter++;
        this.sessionId = sessionCounter;
    }

    public void beginSession() {
        System.out.println("Starting session " + sessionId);
    }

    public void endSession(boolean isSuccess) {
        if(isSuccess) {
            System.out.println("Session " + sessionId + " ended successfully.");
        } else {
            System.out.println("Session " + sessionId + " ended unsuccessfully.");
        }
    }

    public void performOperation(String operation) {
        if(operation.equals("INTEGRITY_FAILURE")) {
            System.out.println("Performing integrity failure operation in session " + sessionId);
            // simulate an integrity failure
            endSession(false);
        } else {
            System.out.println("Performing operation in session " + sessionId);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        SecurityManager securityManager = new SecurityManager();

        securityManager.beginSession();

        securityManager.performOperation("INTEGRITY_FAILURE");

        securityManager.performOperation("NON_INTEGRITY_FAILURE");

        securityManager.endSession(true);
    }
}