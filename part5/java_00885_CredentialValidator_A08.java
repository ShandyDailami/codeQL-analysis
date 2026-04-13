import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

public class java_00885_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    private String userName;
    private String password;

    public java_00885_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Subject validate(Subject subject) throws AuthenticationException {
        if (subject.getPrincipal().equals(this.userName) && subject.getPrivateCredentials().equals(this.password)) {
            return subject;
        }
        throw new AuthenticationException("Invalid username or password");
    }

    @Override
    public void initialize(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        // Not used in this example
    }

}