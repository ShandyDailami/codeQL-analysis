import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_10135_CredentialValidator_A03 implements CallbackHandler {
    private Map<String, String> credentialMap;

    public java_10135_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
        // You can add more credentials here, for example:
        // this.credentialMap.put("username", "password");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handle(Callback callback) throws IOException, LoginException {
        if (callback instanceof UsernamePasswordCallback) {
            UsernamePasswordCallback callback1 = (UsernamePasswordCallback) callback;
            String password = credentialMap.get(callback1.getIdentifier());
            if (password != null) {
                callback1.setPassword(password.toCharArray());
                return true;
            }
        }
        return false;
    }

    public void addCredential(String username, String password) {
        this.credentialMap.put(username, password);
    }
}