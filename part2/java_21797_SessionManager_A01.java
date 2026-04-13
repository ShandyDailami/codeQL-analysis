public class java_21797_SessionManager_A01 extends java.rmi.security.SecurityManager {

    // This is a very simplified version of a security manager
    // that only permits operations on a predefined list of strings.

    private final List<String> permittedActions = Arrays.asList(
        "read", "write", "execute", "delete", "update"
    );

    @Override
    public boolean permitOperation(String op) {
        return permittedActions.contains(op);
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_21797_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void performOperation(String operation) throws Exception {
        // Check permission
        if (!securityManager.permitOperation(operation)) {
            throw new Exception("Operation not permitted");
        }

        // Perform operation
        switch (operation) {
            case "read":
                // Read operation
                System.out.println("Reading data...");
                break;
            case "write":
                // Write operation
                System.out.println("Writing data...");
                break;
            case "execute":
                // Execute operation
                System.out.println("Executing operation...");
                break;
            case "delete":
                // Delete operation
                System.out.println("Deleting data...");
                break;
            case "update":
                // Update operation
                System.out.println("Updating data...");
                break;
        }
    }
}