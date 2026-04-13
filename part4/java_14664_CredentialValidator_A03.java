import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractValidationResult;

public class java_14664_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    private String targetUser;
    private String targetPassword;

    public java_14664_CredentialValidator_A03(String targetUser, String targetPassword) {
        this.targetUser = targetUser;
        this.targetPassword = targetPassword;
    }

    @Override
    public CredentialValidationResult validate(Callback callback) throws LoginException, UnsupportedCallbackException {
        Callback resultCallback = new Callback() {
            @Override
            public void handle(Callback callback) throws UnsupportedCallbackException {
                // Do nothing
            }

            @Override
            public boolean completed(Callback callback, Object response) throws UnsupportedCallbackException {
                return ((String) response).equals(targetPassword);
            }
        };

        callback.setCallback(resultCallback);

        return new AbstractValidationResult() {
            @Override
            public boolean completed() {
                return true;
            }

            @Override
            public Object getResult() {
                return null;
            }
        };
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        return validate(null);
    }
}