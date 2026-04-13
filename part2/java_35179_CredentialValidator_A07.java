import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth. UsernamePasswordCallback;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_35179_CredentialValidator_A07 implements CredentialValidator {
    private Map<String, String> credMap;

    public java_35179_CredentialValidator_A07() {
        credMap = new HashMap<>();
        credMap.put("user1", "password1");
        credMap.put("user2", "password2");
        credMap.put("user3", "password3");
    }

    @Override
    public boolean validate(Subject subject, String username, Object password) {
        String passwd = credMap.get(username);
        return passwd != null && passwd.equals(password.toString());
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public void callback(Callback callback) throws IOException, UnsupportedCallbackException {
                UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
                String password = callbackObj.getPassword();
                callbackObj.setPassword("".toCharArray());
                callbackObj.setPassword(password.toCharArray());
            }

            @Override
            public boolean getIsUserChanged() {
                return false;
            }
        };
    }
}