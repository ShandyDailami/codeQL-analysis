import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;

public class java_03333_CredentialValidator_A01 implements CallbackHandler {

    private String[] credentialIdentifiers;

    public java_03333_CredentialValidator_A01(String[] credentialIdentifiers) {
        this.credentialIdentifiers = credentialIdentifiers;
    }

    @Override
    public AuthenticationStatus callbackHandler(Subject subject, Callback[] callbacks) throws IOException, LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernameCallback) {
                UsernameCallback cb = (UsernameCallback) callback;
                cb.setRequestedPassword("");
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback cb = (PasswordCallback) callback;
                if (Arrays.asList(credentialIdentifiers).contains(cb.getPrompt())) {
                    cb.setRequestedPassword("********");
                } else {
                    cb.setRequestedPassword("");
                }
            }
        }
        return AuthenticationStatus.SUCCESS;
    }
}