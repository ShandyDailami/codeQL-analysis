import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_26035_CredentialValidator_A01 implements CallbackHandler {
    private final Set<String> allowedUsernames = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handle(Callback callback) throws IOException, LoginException {
        UsernamePasswordCallback callbackInfo = (UsernamePasswordCallback) callback;
        if (allowedUsernames.contains(callbackInfo.getIdentifier())) {
            callbackInfo.setPassword(callbackInfo.getIdentifier().toCharArray());
            return true;
        } else {
            throw new LoginException("Access Denied for user: " + callbackInfo.getIdentifier());
        }
    }
}