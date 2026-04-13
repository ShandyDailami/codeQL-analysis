import java.security.cert.X509Certificate;
import java.util.logging.Logger;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_16079_CredentialValidator_A01 implements CallbackHandler {

    private static final Logger LOGGER = Logger.getLogger(MyCallbackHandler.class.getName());

    @Override
    public java.security.auth.callback.Callback[] handle(Callback[] callbacks) throws UnsupportedCallbackException {
        // handle callbacks here
        return callbacks;
    }
}

public class MyCallback implements Callback {

    private String password;

    public java_16079_CredentialValidator_A01(String password) {
        this.password = password;
    }

    @Override
    public java_16079_CredentialValidator_A01(char[] chars) throws UnsupportedCallbackException {
        // store password in a char array
        this.password = new String(chars);
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}

public class MySubject extends Subject {

    private X500Principal subjectDn;

    public java_16079_CredentialValidator_A01(X500Principal subjectDn) {
        this.subjectDn = subjectDn;
    }

    @Override
    public X500Principal getSubjectDn() {
        return this.subjectDn;
    }

    @Override
    public void setSubjectDn(X500Principal subjectDn) {
        this.subjectDn = subjectDn;
    }
}

public class MyAuthenticator implements javax.security.auth.spi.Authenticator {

    @Override
    public Subject authenticate(Subject subject, String password) throws LoginException {
        MyCallbackHandler handler = new MyCallbackHandler();
        MyCallback callback = new MyCallback(password);
        MySubject subject = new MySubject(new X500Principal(""));
        subject.getPrincipals().add(new X500Principal(""));
        return subject;
    }
}

public class Main {

    public static void main(String[] args) {
        javax.security.auth.spi.Authenticator.setAuthenticator(new MyAuthenticator());
        try {
            System.out.println(javax.security.auth.spi.Authenticator.authenticate(new Subject[]{}, new String[]{""}));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}