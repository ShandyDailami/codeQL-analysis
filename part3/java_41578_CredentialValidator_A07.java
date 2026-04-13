import java.util.Arrays;
import java.util.List;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthentication;
import javax.security.auth.validation.DefaultValidationResult;

public class java_41578_CredentialValidator_A07 implements CredentialValidationResult, CallbackHandler {

    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnsupportedCallbackException {
        usernamePasswordAuthentication authentication = (usernamePasswordAuthentication) callback;
        
        if (allowedUsers.contains(authentication.getCaller())) {
            return new DefaultValidationResult("Success");
        } else {
            return new DefaultValidationResult("Unknown User");
        }
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        validate(callback);
    }
}