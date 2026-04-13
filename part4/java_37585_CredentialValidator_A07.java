import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthProvider;
import javax.security.auth.spi.ServiceException;

public class java_37585_CredentialValidator_A07 implements AuthProvider {
    private String password = "password"; // hard-coded password

    @Override
    public Subject.AuthenticationStatus validate(Subject subject, CallbackHandler callbackHandler, Callback[] callbacks) throws ServiceException, UnsupportedCallbackException {
        // No real-world security-sensitive operations here
        return Subject.AuthenticationStatus.SUCCESS;
    }
}