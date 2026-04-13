import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Guard;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class java_07439_SessionManager_A01 implements SecurityManager {

    private static final List<String> AUTHENTICATED_PRINCIPALS = Collections.unmodifiableList(Arrays.asList("john", "mary", "admin"));

    public java_07439_SessionManager_A01() {
        System.out.println("Initializing SecurityManager");
    }

    @Override
    public Subject getSubject(Subject subject, String[] authorities) throws AccessControlException {
        System.out.println("Subject " + (subject == null ? "unauthenticated" : "authenticated") + ": " + Arrays.toString(authorities));
        if (subject != null) {
            System.out.println("Subject is authenticated: " + subject.getPrincipal() + " with authorities: " + Arrays.toString(subject.getAuthorities()));
        }

        if (authorities != null) {
            System.out.println("Authorities: " + Arrays.toString(authorities));
        }

        if (subject == null || !Arrays.asList(subject.getPrincipal()).contains("admin")) {
            throw new AccessControlException("Insufficient access");
        }

        return new MySubject(subject);
    }

    private static class MySubject implements Subject {

        private Subject subject;

        public java_07439_SessionManager_A01(Subject subject) {
            this.subject = subject;
        }

        @Override
        public String getPrincipal() {
            return subject.getPrincipal();
        }

        @Override
        public String getName() {
            return subject.getName();
        }

        @Override
        public List<? extends GrantedAuthority> getAuthorities() {
            return subject.getAuthorities();
        }

        @Override
        public void setAuthenticated(boolean authenticated) throws AccessControlException {
            subject.setAuthenticated(authenticated);
        }

        @Override
        public boolean isAuthenticated() {
            return subject.isAuthenticated();
        }

        @Override
        public boolean hasRole(String role) throws AccessControlException {
            return subject.hasRole(role);
        }

        @Override
        public boolean implies(Subject subject) throws AccessControlException {
            return this.subject.implies(subject);
        }
    }

    @Override
    public boolean hasPermission(Permission permission) throws AccessControlException {
        return false;
    }

    @Override
    public void checkPermission(Permission permission) throws AccessControlException {
        System.out.println("Checking permission: " + permission);
        if (!AUTHENTICATED_PRINCIPALS.contains(permission.getUser())) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void checkPermission(Permission permission, Object resource) throws AccessControlException {
        System.out.println("Checking permission with resource: " + resource);
        if (!AUTHENTICATED_PRINCIPALS.contains(permission.getUser())) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void checkAction(String action) throws AccessControlException {
        System.out.println("Checking action: " + action);
        if (!AUTHENTICATED_PRINCIPALS.contains(action)) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void doAs(String principal, ActivationCallback activationCallback) throws AccessControlException {
        System.out.println("Doing action as: " + principal);
        if (!AUTHENTICATED_PRINCIPIPALS.contains(principal)) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void reauthenticate(Subject subject, String authenticationId, CallbackHandler callbackHandler, Object options) throws UnavailableException, AccessControlException {
        System.out.println("Reauthenticating");
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public boolean getAuthenticationNow() throws UnavailableException, AccessControlException {
        return true;
    }

    @Override
    public AccessControlContext createAccessControlContext(Subject subject, String[] authorities, String callingPrincipal, Object callingIdentity) throws AccessControlException {
        return null;
    }

    @Override
    public AccessControlContext createAccessControlContext(Subject subject, String[] authorities, String callingPrincipal) throws AccessControlException {
        return null;
    }

    @Override
    public Guard getGuard(Subject subject, String callingPrincipal, Object callingIdentity) throws AccessControlException {
        return null;
    }

    @Override
    public AccessControlContext getAccessControlContext() throws AccessControlException {
        return null;
    }

    @Override
    public void checkPermission(Subject subject, Object object, int[] actions) throws AccessControlException {
        System.out.println("Checking permissions on object: " + object);
        if (!AUTHENTICATED_PRINCIPALS.contains(subject.getPrincipal())) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public boolean hasPermission(Subject subject, Object object) throws AccessControlException {
        System.out.println("Checking permission on object: " + object);
        return false;
    }

    @Override
    public boolean getSubjectPermissions(Subject subject, Object object) throws AccessControlException {
        System.out.println("Getting permissions on object: " + object);
        return false;
    }
}