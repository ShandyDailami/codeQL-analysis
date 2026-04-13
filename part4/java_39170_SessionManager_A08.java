public class java_39170_SessionManager_A08 {
    private boolean integrityFailure = false;

    public void setIntegrityFailure(boolean integrityFailure) {
        this.integrityFailure = integrityFailure;
    }

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }

    public void verify() {
        if (isIntegrityFailure()) {
            throw new SecurityException("Integrity failure occurred.");
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_39170_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void performAction() {
        securityManager.verify();
        // rest of the code...
    }
}