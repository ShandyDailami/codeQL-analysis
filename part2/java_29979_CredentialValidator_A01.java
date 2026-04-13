import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.GuardianNotFoundException;
import java.security.Principal;

public class java_29979_CredentialValidator_A01 implements CallbackHandler {

    @Override
    public AuthenticationStatus callbackHandler(Subject subject,
                                                Callback[] callbacks) throws LoginException, GuardianNotFoundException {

        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;

                // Simulate access control check
                if (callbackObj.getPassword().equals("wrongPassword")) {
                    return AuthenticationStatus.FAILURE;
                }

                callbackObj.setRequestedAuthenticationKind(UsernamePasswordCallback.REQUEST_CREDENTIALS);
            }
        }
        return AuthenticationStatus.SUCCESS;
    }
}