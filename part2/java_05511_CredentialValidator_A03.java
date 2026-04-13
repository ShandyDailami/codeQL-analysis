import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Credential;
import java.security.GuardedBy;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class java_05511_CredentialValidator_A03 implements Credential {

    @GuardedBy("this.accessControls")
    private AccessControlList accessControls;

    public java_05511_CredentialValidator_A03() {
        this.accessControls = AccessControlList.newInstance();
    }

    public void doCallbacks(CallbackHandler handler, Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        handler.handle(callbacks);
    }

    public void afterInvocation(String action) throws SecurityException {
    }

    public Credential getCredential(String action) throws LoginException {
        return this;
    }

    public boolean implies(Principal principal) {
        return false;
    }

    public void reset() {
    }

    public Subject getSubject() {
        return null;
    }

    public List<AccessControlList> getAccessControls() {
        return accessControls.getAccessControls();
    }

    public static void main(String[] args) {
        try {
            ServiceLoader<Credential> serviceLoader = ServiceLoader.load(Credential.class);
            Iterator<Credential> iterator = serviceLoader.iterator();
            while (iterator.hasNext()) {
                Credential credential = iterator.next();
                System.out.println(credential.getClass().getSimpleName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}