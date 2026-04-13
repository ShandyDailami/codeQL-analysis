import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.util.Base64;

public class java_40741_CredentialValidator_A08 implements javax.security.auth.callback.CallbackHandler, CredentialValidationResult {
    private Provider provider;
    private CallbackHandler callbackHandler;
    private String userName;
    private String password;
    private boolean isValidated;

    public java_40741_CredentialValidator_A08(String userName, String password, Provider provider) {
        this.provider = provider;
        this.userName = userName;
        this.password = password;
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    public CredentialValidationResult validate(Callback[] callbacks) throws UnsupportedCallbackException {
        if (callbackHandler != null) {
            callbackHandler.handle(callbacks);
        }

        return this;
    }

    public boolean getCredentials(String callingPrincipal, String callingAccessArea, String[] supportedCalledPrincipals, String[] supportedCalledAccessAreas) throws UnsupportedCallbackException {
        if(callingPrincipal.equals(userName) && callingAccessArea.equals("user")) {
            return true;
        }

        return false;
    }

    public boolean getPassword(String callingPrincipal, String callingAccessArea, String[] supportedCalledPrincipals, String[] supportedCalledAccessAreas, String[] outPassword) throws UnsupportedCallbackException {
        if(callingPrincipal.equals(userName) && callingAccessArea.equals("user")) {
            outPassword[0] = password;
            return true;
        }

        return false;
    }

    public boolean getCertificate(String callingPrincipal, String callingAccessArea, String[] supportedCalledPrincipals, String[] supportedCalledAccessAreas, X509Certificate[] outCertificate) throws UnsupportedCallbackException {
        return false;
    }

    public boolean getAttributes(String callingPrincipal, String callingAccessArea, String[] supportedCalledPrincipals, String[] supportedCalledAccessAreas, Map<String, Object> out) throws UnsupportedCallbackException {
        return false;
    }
}