import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.username.UsernamePasswordCallbackHandler;
import javax.security.auth.x500.X500Principal;

public class java_39739_CredentialValidator_A08 implements Subject {
    private UsernamePasswordCallbackHandler handler;

    public java_39739_CredentialValidator_A08() {
        handler = new UsernamePasswordCallbackHandler();
    }

    @Override
    public <A> A invoke(Callback<A> callback) throws UnsupportedCallbackException {
        return handler.invoke(callback);
    }

    public boolean authenticate(String user, String password) {
        return user.equals("admin") && password.equals("password");
    }

    public X500Principal getX500Principal() {
        return null;
    }

    public Subject getSubject() {
        return this;
    }

    public boolean implies(Subject subject) {
        return subject == this;
    }
}