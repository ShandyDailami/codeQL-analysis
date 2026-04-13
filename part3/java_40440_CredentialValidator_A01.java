import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_40440_CredentialValidator_A01 implements CredentialValidationResult, CallbackHandler {

    private Map<String, String> users;

    public java_40440_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackImpl = (UsernamePasswordCallback) callback;
                String userName = callbackImpl.getIdentifier();
                String password = new String(callbackImpl.getPassword());

                if (users.containsKey(userName) && users.get(userName).equals(password)) {
                    return new CredentialValidationResult("Success", null);
                }
            }
        }
        return new CredentialValidationResult("Failure", null);
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        throw new UnsupportedCallbackException(callback, "Unsupported callback");
    }

    public static void main(String[] args) {
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator();
        UsernamePasswordCallback callback = new UsernamePasswordCallback("user1", "password1");
        CredentialValidationResult result = credentialValidator.validate(new Callback[]{callback});
        System.out.println(result.getStatus());
    }
}