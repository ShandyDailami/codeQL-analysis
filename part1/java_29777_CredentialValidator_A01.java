import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizationId;
import javax.security.sasl.RealmCallback;
import java.io.IOException;
import java.util.Arrays;

public class java_29777_CredentialValidator_A01 implements CallbackHandler {

    @Override
    public Callback[] getCallbacks() {
        return new Callback[]{new RealmCallback()};
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException, IOException {
        RealmCallback callback = (RealmCallback) callbacks[0];

        // set credentials and call back
        callback.setRequestingPrincipal("admin");
        callback.setRequestorPrincipal("admin");
        callback.setAuthorizationId(new AuthorizationId(""));
        callback.setRealmName("CustomRealm");
        callback.setCredentials("secret");
    }
}

public class CustomCredentialValidator implements javax.security.auth.spi.CredentialValidator {

    @Override
    public Subject validate(Subject subject) throws java.lang.Exception {
        return subject;
    }

    @Override
    public void refresh() throws java.lang.Exception {
        // no need to refresh for this example
    }
}