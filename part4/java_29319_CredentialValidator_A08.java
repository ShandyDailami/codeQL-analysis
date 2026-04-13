import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.security.AccessControlAction;
import java.security.AccessController;
import java.security.GuardedBy;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class java_29319_CredentialValidator_A08 implements CallbackHandler {
    @GuardedBy("this.credentials")
    private final Map<String, String> credentials = new HashMap<>();

    public java_29319_CredentialValidator_A08() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        Subject subject = (Subject) callbacks[0].getSubject();
        subject.getPrincipals().add(new UserPrincipal("user1"));
        subject.getPublicKey("user1").setKey(/* getPublicKey() */);
        subject.getPrivateKey("user1").setKey(/* getPrivateKey() */);
        AccessController.doPrivileged(new AccessControlAction() {
            public Object run() {
                credentials.put("user3", "password3");
                return null;
            }
        });
    }
}