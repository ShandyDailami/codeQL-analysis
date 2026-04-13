import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.PasswordChangeRequiredException;
import javax.security.auth.credential.CredentialNotFoundException;
import javax.security.auth.credential.CredentialsNotFoundException;
import javax.security.auth.credential.CredentialAccessException;
import javax.security.auth.credential.CredentialException;

public class java_07682_CredentialValidator_A08 implements javax.security.auth.CredentialValidator {

    private String username = "user";
    private String password = "password";

    public java_07682_CredentialValidator_A08() {
        super();
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) throws CredentialException, CredentialsNotFoundException, CredentialAccessException, CredentialNotFoundException, PasswordChangeRequiredException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            if(usernamePasswordCredential.getUsername().equals(this.username) && usernamePasswordCredential.getPassword().equals(this.password)) {
                return new CredentialValidationResult("Validated", null, null, null);
            } else {
                return new CredentialValidationResult("Invalid credentials", null, null, null);
            }
        } else {
            return new CredentialValidationResult("Invalid credentials type", null, null, null);
        }
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Credential credential) throws CredentialException, CredentialsNotFoundException, CredentialAccessException, CredentialNotFoundException, PasswordChangeRequiredException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Credential credential, String callingPrincipal, String callingAccess) throws CredentialException, CredentialsNotFoundException, CredentialAccessException, CredentialNotFoundException, PasswordChangeRequiredException {
        return false;
    }
}