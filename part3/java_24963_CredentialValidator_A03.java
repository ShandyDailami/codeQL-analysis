import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_24963_CredentialValidator_A03 implements CredentialValidator {

    private String user;
    private String password;

    public java_24963_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public Credential validate(Subject subject, Credential credential) {
        String inputUser = credential.getID();
        String inputPassword = credential.getPassword();

        if (user.equals(inputUser) && password.equals(inputPassword)) {
            return credential;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public CredentialValidationResult validate(Subject subject, Credential credential, Callback[] callbacks) throws LoginException, java.io.IOException {
                return validate(subject, credential);
            }
        };
    }
}