import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthProvider;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;

public class java_16558_CredentialValidator_A07 implements AuthProvider {

    @Override
    public Subject login() throws LoginException {
        throw new LoginException("Testing login method");
    }

    @Override
    public Subject login(String arg0) throws LoginException {
        throw new LoginException("Testing login method with argument");
    }

    @Override
    public Subject logout() throws LoginException {
        throw new LoginException("Testing logout method");
    }

    @Override
    public Subject logout(String arg0) throws LoginException {
        throw new LoginException("Testing logout method with argument");
    }

    @Override
    public SaslClient createSaslClient(String arg0, String arg1, String arg2, String arg3, CallbackHandler callbackHandler) throws LoginException {
        throw new LoginException("Testing create sasl client method");
    }

    @Override
    public SaslServer createSaslServer() throws LoginException {
        throw new LoginException("Testing create sasl server method");
    }

    @Override
    public void initialize(Subject arg0, CallbackHandler callbackHandler) throws LoginException {
        throw new LoginException("Testing initialize method");
    }

    @Override
    public void validate(Subject subject, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        // Do nothing, just validate
    }
}