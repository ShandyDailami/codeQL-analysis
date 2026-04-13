import javax.naming.ldap.LdapName;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlAction;
import java.security.AccessControlContext;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.GuardSpi;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.Collections;

public class java_36316_CredentialValidator_A01 implements CredentialValidator {

    private AccessControlContext context;
    private AccessControlListener listener;

    public java_36316_CredentialValidator_A01() {
        context = new AccessControlContext();
        listener = new AccessControlListener() {
            public void checkPrivate(Guard g) throws AccessControlException {
            }

            public void checkReadAccess(Guard g) throws AccessControlException {
            }

            public void checkWriteAccess(Guard g) throws AccessControlException {
            }

            public void checkDeleteAccess(Guard g) throws AccessControlException {
            }

            public void checkAttributesAccess(Guard g) throws AccessControlException {
            }
        };
        context.getGuard(listener);
    }

    public void validate(final Callback[] callbacks)
            throws UnsupportedCallbackException, AccessControlException {
        context.getGuard(listener).checkReadAccess(null);
    }

    public void setCallbackHandler(final CallbackHandler handler) {
        // Do nothing here.
    }

    public AccessControlContext getAccessControlContext() {
        return context;
    }

    public static class Main {

        public static void main(String[] args) throws AccessControlException {
            new VanillaCredentialValidator().validate(new Callback[]{});
        }
    }
}