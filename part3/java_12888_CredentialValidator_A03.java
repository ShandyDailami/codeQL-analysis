import java.util.Base64;
import java.util.Optional;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_12888_CredentialValidator_A03 implements LoginModule {

    private String user;
    private String password;
    private Subject subject;
    private Credential credential;

    public java_12888_CredentialValidator_A03() {}

    public java_12888_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        this.subject = subject;
        this.credential = new UsernamePasswordCredential(user, password);
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        CredentialValidationResult result = new CredentialValidationResult("Success");
        Optional.ofNullable(callbackHandler).ifPresent(h -> {
            try {
                callbackHandler.handle(new Callback[]{new CredentialValidationCallback(result)});
            } catch (LoginException | UnsupportedCallbackException e) {
                result = new CredentialValidationResult("Invalid credentials");
            }
        });
        return result;
    }

    private class CredentialValidationCallback implements Callback {

        private CredentialValidationResult result;

        public java_12888_CredentialValidator_A03(CredentialValidationResult result) {
            this.result = result;
        }

        @Override
        public void handle(Callback callback) throws UnsupportedCallbackException {
            this.result = (CredentialValidationResult) callback;
        }

        @Override
        public CredentialValidationResult getResult() {
            return result;
        }
    }
}