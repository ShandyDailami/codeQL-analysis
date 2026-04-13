import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_37288_CredentialValidator_A01 implements CredentialValidator {

    private String pattern;

    public java_37288_CredentialValidator_A01(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Credential validate(Subject subject, Credential credential) throws LoginException {
        String password = credential.getCredentialIdentifier();
        if (!password.matches(pattern)) {
            throw new LoginException("Password does not match the pattern");
        }
        return credential;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public Credential validate(Subject subject, Credential credential, String target) throws LoginException {
                return validate(subject, credential);
            }

            @Override
            public void refresh(Subject subject, Credential credential, String target) throws LoginException {
                // No need to do anything in this case, since we're not actually validating the credentials
            }
        };
    }
}