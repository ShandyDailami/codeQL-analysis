import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.Principal;

public class java_20502_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public AuthenticationStatus callbackHandler(Subject subject,
                                                CallbackHandler callbackHandler,
                                                Callback[] callbacks)
                                            throws LoginException, java.io.IOException {

        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequestedPrincipal(new Principal() {
                    public String getName() {
                        return "User";
                    }
                });
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                cb.setRequestedPassword("Password");
            }
        }

        return AuthenticationStatus.SUCCESS;
    }
}