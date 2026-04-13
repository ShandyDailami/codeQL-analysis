public class java_02610_SessionManager_A01 {
    private boolean isAccessible;

    public java_02610_SessionManager_A01(boolean isAccessible) {
        this.isAccessible = isAccessible;
    }

    public void startSession() {
        if (isAccessible) {
            System.out.println("Session started.");
        } else {
            throw new SecurityException("Attempted to access insecure session.");
        }
    }

    public void endSession() {
        if (isAccessible) {
            System.out.println("Session ended.");
        } else {
            throw new SecurityException("Attempted to access insecure session.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager(true); // Session is accessible

        manager.startSession(); // Should print "Session started."

        SessionManager managerInsecure = new SessionManager(false); // Session is insecure

        try {
            managerInsecure.startSession(); // Should throw SecurityException
        } catch (SecurityException e) {
            System.out.println(e.getMessage()); // Should print "Attempted to access insecure session."
        }
    }
}