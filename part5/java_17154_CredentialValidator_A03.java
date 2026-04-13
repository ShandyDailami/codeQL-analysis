import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_17154_CredentialValidator_A03 implements LoginModule {

    private String user;
    private String password;
    private Map<String, String> credentials;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options)
            throws LoginException, UnsupportedCallbackException {
        // Here you can put the real user credentials and store them in a map
        this.credentials = new HashMap<>();
        this.credentials.put("user", "admin");
        this.credentials.put("password", "password");
    }

    @Override
    public boolean validate() throws LoginException {
        // Check if the user credentials match
        String enteredUser = this.credentials.get("user");
        String enteredPassword = this.credentials.get("password");

        // Decode the base64 encoded password
        byte[] decodedPassword = Base64.getDecoder().decode(enteredPassword);
        String decodedPasswordStr = new String(decodedPassword);

        return this.user.equals(enteredUser) && this.password.equals(decodedPasswordStr);
    }

    @Override
    public boolean commit() throws LoginException {
        // If the password was successfully validated, return true, otherwise false
        return this.validate();
    }

    @Override
    public void cleanup() {
        // Nothing to cleanup in this case
    }
}