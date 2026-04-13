import java.security.cert.X509Certificate;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.MessageStateException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.AuthToken;
import javax.security.auth.message.buffer.MessageBuffer;
import javax.security.auth.message.buffer.MessageBufferFactory;
import javax.security.auth.message.buffer.MessageBufferOutputStream;

public class java_40176_CredentialValidator_A07 implements CredentialValidator {

    private String myRealm = "MyRealm";
    private KeyStore myKeyStore;
    private PrivateKey myPrivateKey;
    private String myUser = "user";
    private String myPassword = "password";

    public java_40176_CredentialValidator_A07() {
        try {
            myKeyStore = KeyStore.getInstance("JKS");
            myKeyStore.load(getClass().getResourceAsStream("/keystore"), "password".toCharArray());
            myPrivateKey = (PrivateKey) myKeyStore.getKey("myKey", "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AuthStatus validate(Subject subject, CredentialCredential cc) throws CredentialFailureException {
        return validate(subject, (UsernamePasswordCredential) cc);
    }

    @Override
    public AuthStatus validate(Subject subject, CredentialCredential cc) throws CredentialFailureException {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) cc;
        String password = usernamePasswordCredential.getPassword();
        AuthStatus status = AuthStatus.ERROR;
        try {
            if (password.equals(myPassword)) {
                status = AuthStatus.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean getRequestedAuthStatus(Subject subject, CredentialCredential cc) throws CredentialFailureException {
        return validate(subject, cc).equals(AuthStatus.SUCCESS);
    }

    @Override
    public boolean supports(String authMethod) throws UnsupportedAuthMethodException {
        return true;
    }

    @Override
    public boolean handles(AuthToken authToken) throws UnsupportedOperationException {
        return true;
    }

    @Override
    public boolean handles(MessageState messageState) throws UnsupportedOperationException {
        return true;
    }

    @Override
    public boolean handles(Object message) throws UnsupportedOperationException {
        return true;
    }

    @Override
    public AuthToken requestMessage(MessageState messageState) throws CredentialFailureException {
        return new AuthTokenCallbackHandler().generateAuthToken(messageState);
    }

    @Override
    public AuthToken requestMessage(MessageState messageState, Object message) throws CredentialFailureException {
        return new AuthTokenCallbackHandler().generateAuthToken(messageState, message);
    }

    @Override
    public MessageBuffer requestMessage(MessageBufferFactory messageBufferFactory, MessageState messageState, Object message) throws CredentialFailureException {
        return new AuthTokenCallbackHandler().generateAuthToken(messageBufferFactory, messageState, message);
    }

    @Override
    public void renew(Subject subject, AuthToken authToken) throws CredentialFailureException {
        AuthTokenCallbackHandler.renew(subject, authToken);
    }

    @Override
    public void ejbInit(\javax.security.auth.session.callback.CallbackHandler callbackHandler, Subject subject, Object caller, MessageState messageState, Object message) throws CredentialFailureException {
        AuthTokenCallbackHandler.init(callbackHandler, subject, caller, messageState, message);
    }

    @Override
    public boolean validate(Subject subject, X509Certificate certificate, Object caller, MessageState messageState, Object message) throws CredentialFailureException, UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, X509Certificate certificate, Object caller, MessageState messageState, Object message, AuthStatus authStatus) throws CredentialFailureException, UnsupportedOperationException {
        return false;
    }

    @Override
    public void cleanup(Subject subject, AuthToken authToken) throws CredentialFailureException {
        AuthTokenCallbackHandler.cleanup(subject, authToken);
    }

    @Override
    public X500Principal getX500Principal(Subject subject) throws CredentialFailureException {
        return new AuthTokenCallbackHandler().getX500Principal(subject);
    }

    @Override
    public AuthStatus validate(Subject subject, AuthToken authToken, Object caller, MessageState messageState, Object message) throws CredentialFailureException {
        return validate(subject, (UsernamePasswordCredential) authToken, caller, messageState, message);
    }

    @Override
    public boolean validate(Subject subject, AuthToken authToken, Object caller, MessageState messageState, Object message, AuthStatus authStatus) throws CredentialFailureException {
        return validate(subject, (UsernamePasswordCredential) authToken, caller, messageState, message, authStatus);
    }
}