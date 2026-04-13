import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredentials;
import javax.security.auth.subject.Subject;

public class java_18887_CredentialValidator_A01 implements CallbackHandler {

    private String user;
    private String password;

    public java_18887_CredentialValidator_A01(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public Credential validate(Subject subject) throws GeneralSecurityException {
        String userName = subject.getPrincipal().toString();
        String password = new String(Base64.getDecoder().decode(this.password));

        if(userName.equals(this.user) && password.equals(this.password)) {
            return new UsernamePasswordCredentials(user, password);
        } else {
            throw new GeneralSecurityException("Authentication failed");
        }
    }

    @Override
    public void handle(Callback[] callbacks)
            throws UnsupportedCallbackException {
        // Not implemented in this class
    }
}