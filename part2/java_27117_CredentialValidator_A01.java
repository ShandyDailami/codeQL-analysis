import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.Guard;
import java.util.Iterator;

public class java_27117_CredentialValidator_A01 implements CredentialValidator {
    private Subject subject;

    public java_27117_CredentialValidator_A01(Subject subject, CallbackHandler callbackHandler) {
        this.subject = subject;
        callbackHandler.handle(new Callback[]{new UsernamePasswordCallback("user", "password")});
    }

    public boolean validate(Subject subject, Object credentials) throws IOException, UnsupportedCallbackException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) credentials;
        if (callback.getIdentifier().equals(callback.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public Iterator getCallerPrincipal() {
        return new GuardedClassIterator(subject);
    }

    public Iterator getUnguardedPrincipal() {
        return getCallerPrincipal();
    }

    private class GuardedClassIterator implements Iterator {
        private Subject subject;
        private Iterator guardedIter;

        public java_27117_CredentialValidator_A01(Subject subject) {
            this.subject = subject;
            guardedIter = subject.getGuardedObjects().iterator();
        }

        public boolean hasNext() {
            return guardedIter.hasNext();
        }

        public Object next() {
            return guardedIter.next();
        }

        public void remove() {
            // no-op
        }
    }

    private class UsernamePasswordCallback implements Callback {
        private String username;
        private String password;

        public java_27117_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getIdentifier() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public boolean handle(Callback callback) throws IOException, UnsupportedCallbackException {
            return true;
        }
    }
}