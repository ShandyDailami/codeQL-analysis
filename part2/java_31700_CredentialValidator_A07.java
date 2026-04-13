import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.GuardedBy;
import java.security.ProtectionDomain;

public class java_31700_CredentialValidator_A07 implements CallbackHandler {
    @GuardedBy("this")
    private Subject subject;

    public java_31700_CredentialValidator_A07() {
        subject = new Subject(new AccessControlContext());
        subject.getPrincipals().add(new PrincipalImpl("user"));
        subject.getGrantedAuthorities().add(new AuthorityImpl("ROLE_USER"));
    }

    public CallbackHandler getCallbackHandler() {
        return this;
    }

    public boolean getCredentials(Callback[] callbacks) throws IOException, LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                callbackImpl.setRequestedPassword("password");
            } else if (callback instanceof AccessControlCallback) {
                AccessControlCallback callbackImpl = (AccessControlCallback) callback;
                callbackImpl.setAccessControl(new AccessControlContext() {
                    public void addCallback(AccessControlListener listener) {
                        throw new UnsupportedOperationException();
                    }
                    public void removeCallback(AccessControlListener listener) {
                        throw new UnsupportedOperationException();
                    }
                    public AccessControlContext getParent() {
                        throw new UnsupportedOperationException();
                    }
                    @GuardedBy("this")
                    public boolean implies(AccessControlContext context) {
                        return context.getPrincipals().contains(subject);
                    }
                });
            }
        }
        return true;
    }
}