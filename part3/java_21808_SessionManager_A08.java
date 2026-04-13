import java.security.Permission;
import java.security.SecurityPermission;

public class java_21808_SessionManager_A08 implements java.security.SessionManager {
    private boolean allowCreateSession;
    private boolean allowCreateInstance;

    public java_21808_SessionManager_A08(boolean allowCreateSession, boolean allowCreateInstance) {
        this.allowCreateSession = allowCreateSession;
        this.allowCreateInstance = allowCreateInstance;
    }

    public java.security.SessionContext createSessionContext(java.security.Principal principal, java.security.AccessControl accessControl) {
        if (allowCreateSession) {
            return new SecuritySessionContext(principal, accessControl);
        } else {
            throw new java.lang.SecurityException("Session creation failed.");
        }
    }

    public java.security.Permission createPermission(String name, String actions) {
        return new SecurityPermission(name);
    }

    private class SecuritySessionContext implements java.security.SessionContext {
        private java.security.Principal principal;
        private java.security.AccessControl accessControl;

        public java_21808_SessionManager_A08(java.security.Principal principal, java.security.AccessControl accessControl) {
            this.principal = principal;
            this.accessControl = accessControl;
        }

        public java.security.Principal getContextElement() {
            return principal;
        }

        public java.security.AccessControl getAccessControl() {
            return accessControl;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        java.security.SecurityManager securityManager = new SecuritySessionManager(true, false);
        java.security.Security.setSecurityManager(securityManager);

        java.security.SessionManager sm = java.security.Security.getSessionManager();
        java.security.Principal principal = new java.security.Principal("John Doe");
        java.security.AccessControl accessControl = sm.newAccessControl(principal, "read");

        java.security.SessionContext sessionContext = sm.createSessionContext(principal, accessControl);
        System.out.println(sessionContext.getContextElement().toString());
    }
}