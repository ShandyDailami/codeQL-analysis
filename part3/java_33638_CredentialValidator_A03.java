import java.util.Base64;
import java.util.zip.DataNotAvailableException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizationStatus;

public class java_33638_CredentialValidator_A03 implements CallbackHandler {

    private String expectedPassword = "expectedPassword";

    public java_33638_CredentialValidator_A03() {}

    @Override
    public AuthorizationStatus validateCredentials(String callingPrincipal, String callingAccessArea, Callback[] callbacks) {
        if (callingPrincipal == null) {
            return AuthorizationStatus.FAILURE;
        }
        if (callbacks == null) {
            return AuthorizationStatus.SUCCESS;
        }

        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackCreds = (UsernamePasswordCallback) callback;
                String providedPassword = callbackCreds.getPassword();

                if (isPasswordValid(providedPassword)) {
                    return AuthorizationStatus.SUCCESS;
                }
            }
        }

        return AuthorizationStatus.FAILURE;
    }

    private boolean isPasswordValid(String providedPassword) {
        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String decodedExpectedPassword = new String(decodedPassword, "UTF-8");

        return decodedExpectedPassword.equals(providedPassword);
    }
}