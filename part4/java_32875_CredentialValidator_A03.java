import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Credential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_32875_CredentialValidator_A03 implements CredentialValidator {

    private static final String USER_DB = "admin";
    private static final String PWD_DB = "password";

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        // create a callback
        Callback callback = new Callback() {
            public void handle(String s) {
                // No need to handle this callback, as we only use it to get the credentials
            }
        };

        // get the credentials
        Map<String, String> credMap = new HashMap<String, String>();
        credMap.put("username", "");
        credMap.put("password", "");
        callbackHandler.handle(callback);

        // validate the credentials
        if (credMap.get("username").equals(USER_DB) && credMap.get("password").equals(PWD_DB)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}