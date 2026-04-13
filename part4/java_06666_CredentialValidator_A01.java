import javax.security.auth.callback.*;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuardedBy;
import java.security.Guardian;
import java.util.HashSet;
import java.util.Set;

public class java_06666_CredentialValidator_A01 implements CallbackHandler {

    @GuardedBy("this.credentials")
    private final Set<String> credentials = new HashSet<>();

    private final AccessControl accessControl = new AccessControl() {
        @Override
        public boolean checkAccess(Guardian guardian, String s) {
            return credentials.contains(s);
        }
    };

    public void addCredential(String credential) {
        credentials.add(credential);
        accessControl.permitAccess(guardian(), credential);
    }

    @Override
    public Callback[] getCallbacks() {
        return new Callback[]{new AccessControlCallback(accessControl)};
    }

    @Override
    public boolean getCredentials(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof AccessControlCallback) {
                ((AccessControlCallback) callback).setAccessGranted(true);
                return true;
            }
        }
        return false;
    }
}