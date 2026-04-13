import java.util.concurrent.locks.ReentrantLock;

public class java_16855_SessionManager_A01 {
    // Declare the lock object
    private static ReentrantLock lock = new ReentrantLock();

    // Declare the session manager object
    private static SessionManager sessionManager = null;

    // Private constructor to prevent instantiation from outside
    private java_16855_SessionManager_A01() {}

    // Public method to get the instance of the session manager
    public static SessionManager getInstance() {
        // Use try-lock to ensure thread safety
        if (lock.tryLock()) {
            try {
                // If the session manager is null, create a new instance
                if (sessionManager == null) {
                    sessionManager = new SessionManager();
                }
                // Return the session manager instance
                return sessionManager;
            } finally {
                // Always unlock the lock when done
                lock.unlock();
            }
        }

        // If the lock couldn't be acquired, return null
        return null;
    }

    // Another method to demonstrate a security-sensitive operation
    public void demonstrateSecuritySensitiveOperation() {
        // Simulate a security-sensitive operation
        System.out.println("Demonstrating security-sensitive operation...");
    }
}