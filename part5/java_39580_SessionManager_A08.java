public class java_39580_SessionManager_A08 {
    // Attributes
    private static int sessionCount = 0;
    
    // Constructor
    public java_39580_SessionManager_A08() {
        sessionCount++;
        System.out.println("Created session: " + sessionCount);
    }
    
    // Destructor
    public void closeSession() {
        sessionCount--;
        if (sessionCount < 0) {
            System.out.println("Closed all sessions");
        } else {
            System.out.println("Closed session: " + sessionCount);
        }
    }
    
    // Method to simulate integrity failure
    public void simulateIntegrityFailure() throws Exception {
        // Simulate some random failure in the integrity process
        if (Math.random() < 0.5) {
            throw new Exception("Simulated integrity failure");
        }
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        SessionManager sm1 = new SessionManager();
        SessionManager sm2 = new SessionManager();
        SessionManager sm3 = new SessionManager();
        
        try {
            sm1.simulateIntegrityFailure();
        } catch (Exception e) {
            System.out.println("Caught exception in sm1: " + e.getMessage());
        }
        
        sm2.closeSession();
        sm3.closeSession();
    }
}