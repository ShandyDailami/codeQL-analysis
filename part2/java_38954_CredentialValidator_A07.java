import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.metadata.Notification;
import javax.security.auth.metadata.ObtainUserCredentialsCommand;
import javax.security.auth.metadata.PasswordQuery;
import javax.security.auth.realm.Realm;
import javax.security.auth.spi.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class java_38954_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_38954_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String realm, String username, String password) {
        this.credentials.put(realm, username);
    }

    @Override
    public String getCallerPrincipal(String arg0) throws UnknownRealmException, RealmUnavailableException {
        return null;
    }

    @Override
    public String getPassword(String arg0) throws UnknownRealmException, RealmUnavailableException {
        return this.credentials.get(arg0);
    }

    @Override
    public String getUsername(String arg0) throws UnknownRealmException, RealmUnavailableException {
        return this.credentials.get(arg0);
    }

    @Override
    public void validate(final CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException, AuthenticationException {
        callbackHandler.handle(new Callback() {
            @Override
            public void handle(final Notification notification) throws IOException, UnsupportedCallbackException {
                switch (notification.getType()) {
                case PasswordQuery:
                    PasswordQuery passwordQuery = (PasswordQuery) notification;
                    passwordQuery.answer(getPassword(passwordQuery.getRequestedOp()));
                    break;
                default:
                    throw new UnsupportedCallbackException(notification.getType());
                }
            }
        });
    }

    @Override
    public boolean equals(Object obj) throws IllegalArgumentException, UnsupportedOperationException {
        return obj.equals(this);
    }

    @Override
    public int hashCode() {
        return 42;
    }
}