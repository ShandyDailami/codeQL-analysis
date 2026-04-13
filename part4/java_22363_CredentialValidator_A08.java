import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_22363_CredentialValidator_A08 implements CallbackHandler {

    private Map<String, String> credentialsMap;

    public java_22363_CredentialValidator_A08(String[] usernames, String[] passwords) {
        credentialsMap = new HashMap<>();
        for (int i = 0; i < usernames.length; i++) {
            credentialsMap.put(usernames[i], passwords[i]);
        }
    }

    @Override
    public boolean handleCallback(Callback[] callbacks) throws IOException, LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackObject = (UsernamePasswordCallback) callback;
                String username = callbackObject.getIdentifier();
                String password = callbackObject.getPassword();

                if (credentialsMap.containsKey(username) && credentialsMap.get(username).equals(password)) {
                    callbackObject.setRequestedPassword(password);
                    return true;
                }
            }
        }
        return false;
    }
}