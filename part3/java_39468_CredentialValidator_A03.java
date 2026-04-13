import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_39468_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {
    private final Pattern pattern;

    public java_39468_CredentialValidator_A03() {
        this.pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        Callback[] callbacks = callbackHandler.getCallbacks();
        String password = null;
        for (Callback callback : callbacks) {
            if (callback instanceof PasswordCallback) {
                password = ((PasswordCallback) callback).getPassword();
            }
        }

        if (password == null) {
            return CredentialValidationResult.failed("No password provided");
        } else {
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                return CredentialValidationResult.success();
            } else {
                return CredentialValidationResult.failed("Password does not meet required pattern");
           
            }
        }
    }
}