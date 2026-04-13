import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordCallback;
import javax.security.auth.x500.X500Principal;

public class java_17595_CredentialValidator_A03 implements CallbackHandler {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        String userName = callback.getIdentifier();
        char[] password = callback.getPassword();

        if (!USERNAME.equals(userName) || !PASSWORD.equals(new String(password))) {
            callback.setUnsupported(true);
        } else {
            callback.setUnsupported(false);
        }
    }
}

public class CustomCredentialValidator implements javax.security.auth.spi.CredentialValidator {
    private String realm;

    public java_17595_CredentialValidator_A03(String realm) {
        this.realm = realm;
    }

    @Override
    public String getCallerPrincipal() {
        return realm;
    }

    @Override
    public String getUniqueIdentifier() {
        return realm;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CustomCallbackHandler();
    }

    @Override
    public X500Principal getSubject() {
        throw new UnsupportedOperationException();
    }
}