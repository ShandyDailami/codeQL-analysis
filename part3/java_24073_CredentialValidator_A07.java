import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.realm.Realm;
import javax.security.auth.SubjectCredentialCollection;
import java.io.IOException;
import java.util.Collections;

public class java_24073_CredentialValidator_A07 implements Realm.AuthenticationHandler {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Subject subject, String username, Credential credential) {
        CredentialValidationResult result = null;

        if (USERNAME.equals(username)) {
            if (credential instanceof UsernamePasswordCredential) {
                UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
                result = new CredentialValidationResult(USERNAME, upCredential.getPassword(), Collections.emptySet());
            } else {
                result = new CredentialValidationResult(USERNAME, null, Collections.singletonList(new java.security.AuthenticationException("No UsernamePasswordCredential object")));
            }
        } else {
            result = new CredentialValidationResult(USERNAME, null, Collections.singletonList(new java.security.AuthenticationException("Invalid username")));
        }

        return result;
    }

    @Override
    public void refresh(Subject subject, String username, Credential credential, CallbackHandler callbackHandler, SubjectCredentialCollection credCollection) {
        // No operation
    }
}