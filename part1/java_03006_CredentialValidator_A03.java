import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_03006_CredentialValidator_A03 implements CallbackHandler {

    private Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private Subject subject;

    public java_03006_CredentialValidator_A03(Subject subject) {
        this.subject = subject;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean getRequestedCredential(String arg0, String arg1, Callback[] arg2) throws IOException, LoginException {
        if (allowedUsers.contains(arg1)) {
            arg2[0] = new UsernamePasswordCallback("user1", "password1".toCharArray());
            return true;
        } else {
            arg2[0] = new UsernamePasswordCallback("", "");
            return false;
        }
    }

    @Override
    public boolean handle(Callback[] callbacks) throws IOException, LoginException {
        for (Callback callback : callbacks) {
            UsernamePasswordCallback callbackEntry = (UsernamePasswordCallback) callback;
            if (callbackEntry.getIdentifier().equals("")) {
                if (allowedUsers.contains(callbackEntry.getPasswordAsString())) {
                    callbackEntry.setPassword("********");
                    return true;
                }
            } else if (allowedUsers.contains(callbackEntry.getIdentifier())) {
                callbackEntry.setPassword("********");
                return true;
            }
        }
        return false;
    }
}