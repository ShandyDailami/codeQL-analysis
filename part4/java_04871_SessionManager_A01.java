import java.util.HashSet;
import java.util.Set;

public class java_04871_SessionManager_A01 {
    private Set<String> secureOperations;

    public java_04871_SessionManager_A01() {
        secureOperations = new HashSet<String>();
        // Adding some secure operations
        secureOperations.add("read");
        secureOperations.add("write");
        secureOperations.add("delete");
    }

    public boolean isOperationSecure(String operation) {
        return secureOperations.contains(operation);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_04871_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void performOperation(String operation) {
        if (securityManager.isOperationSecure(operation)) {
            // Perform secure operation
            System.out.println("Performing secure operation: " + operation);
        } else {
            System.out.println("Not performing operation: " + operation);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);

        sessionManager.performOperation("read");    // Should print "Performing secure operation: read"
        sessionManager.performOperation("write");   // Should print "Performing secure operation: write"
        sessionManager.performOperation("delete");  // Should print "Performing secure operation: delete"
        sessionManager.performOperation("execute"); // Should print "Not performing operation: execute"
    }
}