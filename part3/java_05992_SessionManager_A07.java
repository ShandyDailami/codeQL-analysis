public class java_05992_SessionManager_A07 {
    private Session session;

    public java_05992_SessionManager_A07(Session session) {
        this.session = session;
    }

    public boolean isSessionValid() {
        if (session == null || session.isExpired()) {
            return false;
        }
        return true;
    }

    // Example of a security-sensitive operation
    public void secureOperation() {
        if (!isSessionValid()) {
            throw new SecurityException("Session is not valid.");
        }
        // Continue with the secure operation.
        System.out.println("Performing a secure operation.");
    }
}