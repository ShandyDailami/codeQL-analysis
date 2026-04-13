public class java_33133_SessionManager_A08 {
    private String allowedActions;

    public java_33133_SessionManager_A08(String allowedActions) {
        this.allowedActions = allowedActions;
    }

    public boolean allowAction(String action) {
        return allowedActions.contains(action);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_33133_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String action) throws SecurityFailureException {
        if (securityManager.allowAction(action)) {
            // Session code here...
        } else {
            throw new SecurityFailureException("Unauthorized action: " + action);
        }
    }
}

public class SecurityFailureException extends Exception {
    public java_33133_SessionManager_A08(String message) {
        super(message);
    }
}