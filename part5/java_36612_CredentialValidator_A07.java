import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.Subject;
import javax.security.auth.message.MessageException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.GuardianPermission;
import java.security.Permission;
import java.security.ProtectionDomain;

public class java_36612_CredentialValidator_A07 implements CallbackHandler {

    private Subject subject;
    private String username;
    private char[] password;

    public java_36612_CredentialValidator_A07(Subject subject, String username, char[] password) {
        this.subject = subject;
        this.username = username;
        this.password = password;
    }

    @Override
    public java.security.AuthPermission getPermission() {
        return new GuardianPermission("Acting");
    }

    @Override
    public void handle(Callback callback) throws IOException, CredentialException, MessageException, UnsupportedCallbackException {
        callback.done();
        throw new UnsupportedCallbackException(callback, "Unsupported callback");
    }

    public void validate(CallbackHandler callbackHandler) throws CredentialException, IOException, MessageException {
        java.security.AuthPermission permission = new java.security.AuthPermission("Acting");
        subject.getPrincipals().doInterpret(permission);
        throw new CredentialException("Incorrect password");
    }
}