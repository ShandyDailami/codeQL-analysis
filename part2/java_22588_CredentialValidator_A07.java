import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_22588_CredentialValidator_A07 implements CredentialValidationResult, CallbackHandler {

    private Set<String> supportedCredentials = new HashSet<>(Arrays.asList("Basic", "Digest", "Federated", "NTLM", "OAuth", "SAML", "SOAP", "UMA", "Unknown"));
    private Set<String> unsupportedCredentials = new HashSet<>(Arrays.asList("Certificate", "ClientCertificate", "JWT", "JWTClientCertificate", "JWTSAML"));

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                String credential = callbackImpl.getPasswordAsString();
                if (supportedCredentials.contains(credential) && !unsupportedCredentials.contains(credential)) {
                    return new CredentialValidationResult("OK", null);
                } else {
                    return new CredentialValidationResult("Unknown", null);
                }
            }
        }
        throw new UnsupportedCallbackException("Unsupported callback: " + callbacks[0].getClass().getName());
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate(new Callback[]{new UsernamePasswordCallback("test", "test")}));
    }
}