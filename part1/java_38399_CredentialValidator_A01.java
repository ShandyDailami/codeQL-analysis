import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.ServiceException;
import javax.security.auth.Subject;
import java.security.Principal;
import java.security.auth.Destroyable;
import java.security.Principal;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.Callback;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import javax.security.auth.Subject;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import javax.security.auth.Subject;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_38399_CredentialValidator_A01 implements AuthenticationService {

    private Set<Principal> principals;
    private Set<Principal> groups;
    private boolean isAuthenticated;

    public java_38399_CredentialValidator_A01() {
        this.principals = new HashSet<>();
        this.groups = new HashSet<>();
        this.isAuthenticated = false;
    }

    @Override
    public boolean supports(String option) throws ServiceException {
        return false;
    }

    @Override
    public boolean authenticate(String user, String pswd) throws ServiceException {
        if ("user1".equals(user) && "user1".equals(pswd)) {
            this.isAuthenticated = true;
            this.principals.add(new Principal("user1"));
            this.groups.add(new Principal("user"));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getSubject() throws ServiceException {
        return false;
    }

    @Override
    public boolean setSubject(Subject subject) throws ServiceException {
        return false;
    }

    @Override
    public Set<Principal> getGroups(String user) throws ServiceException {
        return this.groups;
    }

    @Override
    public boolean setCallerPrincipal(Principal principal) throws ServiceException {
        return false;
    }

    @Override
    public Principal getCallerPrincipal() throws ServiceException {
        return null;
    }

    @Override
    public boolean implies(Subject subject, String role) throws ServiceException {
        return false;
    }

    @Override
    public void clearSubject() throws ServiceException {
        return;
    }

    @Override
    public void dispose() throws Destroyable {
        return;
    }

    @Override
    public Set<Principal> getPrincipals(String user) throws ServiceException {
        return this.principals;
    }

    @Override
    public Subject getSubject(boolean reauthenticate) throws ServiceException {
        return null;
    }
}

public class CustomCallbackHandler implements CallbackHandler {

    @Override
    public Callback[] getCallbacks() throws UnsupportedCallbackException {
        return new Callback[0];
    }

    @Override
    public void setCallbacks(Callback[] callbacks) throws UnsupportedCallbackException {
        // Do nothing
    }
}

public class CustomSecurityContext {

    private Subject subject;

    public java_38399_CredentialValidator_A01() {
        this.subject = Subject.getSubject(this);
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void runAs(String user) throws Exception {
        if (user != null && !user.isEmpty()) {
            subject = Subject.getSubject(this, user, user, new CustomCallbackHandler());
        }
    }
}

public class SecurityTest {

    public static void main(String[] args) {
        CustomSecurityContext securityContext = new CustomSecurityContext();
        securityContext.runAs("user1");
    }
}