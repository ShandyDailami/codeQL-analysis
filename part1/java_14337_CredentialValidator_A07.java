import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import java.security.Guard;
import java.util.Arrays;
import java.util.Base64;

public class java_14337_CredentialValidator_A07 implements CallbackHandler {
    private final static String[] hardCodedPasswords = {"password1", "password2", "password3"};
    private final Guard guard;

    public java_14337_CredentialValidator_A07(Guard guard) {
        this.guard = guard;
    }

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnsupportedCallbackException {
        String password = callback.getPassword();
        if (Arrays.asList(hardCodedPasswords).contains(password)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure();
        }
    }
}

public class CustomGuard implements Guard {
    private final CustomCallbackHandler callbackHandler = new CustomCallbackHandler(this);

    @Override
    public CredentialValidationResult validatePassword(String password) {
        return callbackHandler.validate(new Callback() {
            @Override
            public String getPassword() {
                return password;
            }

            @Override
            public String getCallerPrincipal() {
                return null;
            }

            @Override
            public void eraseCredentials() {

            }
        });
    }

    public static void main(String[] args) {
        CustomGuard guard = new CustomGuard();
        guard.validatePassword("password1"); // Should print success
        guard.validatePassword("wrongPassword"); // Should print failure
    }
}