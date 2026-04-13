import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.metadata.AuthMetadata;
import javax.security.auth.metadata.PasswordAuthenticationStatus;
import javax.security.auth.metadata.StreamedAuthStatus;
import javax.security.auth.metadata.UsernamePasswordMetadata;
import javax.security.auth.realm.Realm;
import javax.security.auth.realm.RealmBase;

public class java_21915_CredentialValidator_A01 implements RealmBase, CallbackHandler {

    private String user = "user";
    private String password = "password";
    private boolean authenticated = false;

    // RealmBase

    @Override
    public StreamedAuthStatus validate(Subject subject,
            UsernamePasswordMetadata usernamePasswordMetadata) {
        if (usernamePasswordMetadata.getPassword() != null) {
            String pwd = new String(usernamePasswordMetadata.getPassword());
            if (pwd.equals(this.password)) {
                this.authenticated = true;
                return new StreamedAuthStatus(null);
            }
        }
        return new StreamedAuthStatus(null);
    }

    @Override
    public AuthMetadata retrieveAuthMetadata() {
        // we can use a simple username-password authentication
        return new UsernamePasswordMetadata();
    }

    @Override
    public boolean commit(Callback[] callbacks) throws UnsupportedCallbackException {
        return false;
    }

    // CallbackHandler

    @Override
    public PasswordAuthenticationStatus validate(Subject subject,
            String username, String password) {
        if (username.equals(this.user) && password.equals(this.password)) {
            return new PasswordAuthenticationStatus(this.authenticated);
        } else {
            return new PasswordAuthenticationStatus(false);
        }
    }

    @Override
    public void getCallerDenied(Subject subject, String action)
            throws UnsupportedCallbackException {
    }

    @Override
    public void setCallback(Callback[] callbacks, Class<? extends Subject> subjectClass,
            Class<? extends AuthMetadata> authMetadataClass, Class<? extends CallbackHandler> handlerClass,
            Class<? extends StreamedAuthStatus> streamedAuthStatusClass)
            throws UnsupportedCallbackException {
    }
}