public class java_06510_SessionManager_A08 {
    private static int sessionCount = 0;

    public java_06510_SessionManager_A08() {
        sessionCount++;
        System.out.println("SessionManager " + sessionCount + " created.");
    }

    public void beginSession() {
        System.out.println("Starting a new session.");
    }

    public void commitTransaction() {
        System.out.println("Committing the transaction.");
    }

    public void endSession() {
        sessionCount--;
        System.out.println("SessionManager " + sessionCount + " destroyed.");
        System.out.println("Ending the session.");
    }

    public void rollbackTransaction() {
        System.out.println("Rolling back the transaction.");
    }

    public void setSecurityInfo(String username, String password) {
        System.out.println("Setting security information for user " + username);
        // Here we're not storing the password anywhere, it's not secure at all,
        // but for the purpose of simplicity we'll do this.
    }

    public void clearSecurityInfo() {
        System.out.println("Clearing security information.");
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.beginSession();
        sm.setSecurityInfo("John", "Doe");
        sm.commitTransaction();
        sm.clearSecurityInfo();
        sm.endSession();
    }
}