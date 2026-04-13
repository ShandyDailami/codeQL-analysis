import javax.security.auth.callback.*;

public class java_33938_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public boolean validate(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // Loop through the callbacks
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                // Attempt to log in with the provided credentials.
                // In this case, we're just returning true, as we know the credentials are correct.
                if ("user".equals(callbackImpl.getUsername()) && "password".equals(callbackImpl.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

}