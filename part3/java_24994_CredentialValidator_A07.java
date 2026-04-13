import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordCallbackHandler;
import javax.security.auth.validate.AbstractCredentialValidator;
import javax.security.auth.validate.MalformedParametersException;
import javax.security.auth.validate.ValidatorException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_24994_CredentialValidator_A07 extends AbstractCredentialValidator {

    private final Map<String, String> credentials = new HashMap<>();

    public java_24994_CredentialValidator_A07() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    @Override
    public String getAuthorizationId() {
        return "CustomAuthorizationID";
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler) throws ValidatorException {
        Callback callback = callbackHandler.getCallback();

        if (callback instanceof UsernamePasswordCallbackHandler) {
            UsernamePasswordCallbackHandler usernamePasswordCallbackHandler = (UsernamePasswordCallbackHandler) callback;

            String presentedPassword = usernamePasswordCallbackHandler.getPassword();
            String presentedUsername = usernamePasswordCallbackHandler.getUsername();

            String expectedPassword = credentials.get(presentedUsername);

            if (expectedPassword == null || !expectedPassword.equals(presentedPassword)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler, Map<String, String> additionalInfo) throws ValidatorException, MalformedParametersException {
        return validate(callbackHandler);
    }
}