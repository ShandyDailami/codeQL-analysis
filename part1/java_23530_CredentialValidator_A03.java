import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.GuaranteedAccessException;
import java.security.UnguarantiedAccessException;

public class java_23530_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public AuthenticationStatus callbackHandler(Subject subject, Callback[] callbacks) throws LoginException, UnguarantiedAccessException, GuaranteedAccessException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackName = (UsernamePasswordCallback) callback;
                callbackName.setRequestedPassword("*****"); // Hide password
                callbackName.setRequestedPassword(null); // Remove password
            }
        }
        return AuthenticationStatus.SUCCESS;
    }
}