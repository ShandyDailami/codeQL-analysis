import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizationFailureException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslClientCallback;

public class java_17163_CredentialValidator_A07 implements CredentialValidator {

    private SaslClient saslClient;

    public java_17163_CredentialValidator_A07() {
        saslClient = new SaslClientFactory().getSaslClient("SASLMechanism1");
    }

    @Override
    public Subject getSubject(String arg0, String arg1, CallbackHandler arg2) throws UnsupportedCallbackException, AuthorizationFailureException {
        return null;
    }

    @Override
    public void validate(String arg0, Object arg1, CallbackHandler arg2) throws UnsupportedCallbackException, AuthorizationFailureException {
        Callback callback = new Callback() {
            @Override
            public java_17163_CredentialValidator_A07(String arg0, String arg1) throws UnsupportedCallbackException {

            }
        };
        saslClient.login();
    }
}