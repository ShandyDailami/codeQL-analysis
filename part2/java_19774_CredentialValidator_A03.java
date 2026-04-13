import java.util.Base64;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509Principal;

public class java_19774_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> validationData;

    public java_19774_CredentialValidator_A03(Map<String, String> validationData) {
        this.validationData = validationData;
    }

    @Override
    public UsernamePasswordAuthenticationToken getPasswordAuthenticationToken(String userName, String password, String callerPrincipal, X500Principal sAMAccountName, X509Principal x509Certificate) {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        // handle callbacks here
    }
}

public class CustomCredentialValidator implements javax.security.auth.credential.CredentialValidator {

    private String realm;

    public java_19774_CredentialValidator_A03(String realm) {
        this.realm = realm;
    }

    @Override
    public UsernamePasswordAuthenticationToken validate(CallbackHandler callbackHandler) {
        // validate the credentials here and return the authentication token
        return null;
    }

    @Override
    public String getNormativeRealm() {
        return realm;
    }

    @Override
    public String getOptionalRealm() {
        return null;
    }

    @Override
    public boolean supports(String authenticationScheme) {
        return authenticationScheme.equals("CUSTOM");
    }
}