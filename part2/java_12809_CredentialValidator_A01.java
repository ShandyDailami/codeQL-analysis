import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

public class java_12809_CredentialValidator_A01 implements CallbackHandler {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public Callback[] handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof AuthorizeCallback) {
                AuthorizeCallback authorizeCallback = (AuthorizeCallback) callbacks[i];
                Subject subject = authorizeCallback.getSubject();
                String authId = subject.getPrincipal().toString();
                char[] password = new char[0];
                subject.getPrivateCredentials(USERNAME, (char[]) null, password, null, null);
                if (authId.equals(USERNAME) && new String(password).equals(PASSWORD)) {
                    return new Callback[] {};
                }
                authorizeCallback.setCancel(true);
            }
        }
        throw new UnsupportedCallbackException(callbacks[0], "Unsupported callback");
    }

    public static void main(String[] args) {
        SaslClient saslClient = null;
        try {
            saslClient = SaslClient.getInstance("MyRealm");
            saslClient.setCallbackHandler(new MyCredentialValidator());
            saslClient.login();
            System.out.println("Successfully authenticated");
        } catch (SaslException e) {
            e.printStackTrace();
        } finally {
            if (saslClient != null) {
                saslClient.logout();
            }
        }
    }
}