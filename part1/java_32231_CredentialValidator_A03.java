import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_32231_CredentialValidator_A03 implements Credential {

    private String username;
    private String password;

    public java_32231_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean validate() {
        return this.username.equals("admin") && this.password.equals("password");
    }

    public Subject getSubject() {
        return null;
    }

    public CredentialValidationResult validationResult() {
        if (validate()) {
            return new CredentialValidationResult("Success");
        } else {
            return new CredentialValidationResult("Failure");
        }
    }

}

public class MyCallbackHandler implements CallbackHandler {

    public Credential authenticate(String type, Credential credential) throws LoginException {
        if ("Password".equals(type)) {
            return credential;
        } else {
            throw new LoginException("Unknown credential type");
        }
    }

    public Credential getCredential(String type, Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        return authenticate(type, (Credential) callbacks[0]);
    }

}