import javax.security.auth.credential.UnmarshalledPasswordCredential;
import javax.security.auth.login.PasswordAuthenticationStatus;
import javax.security.auth.credential.Credential;
import javax.security.auth.AuthException;
import javax.security.auth.login.LoginException;
import java.security.AccessControlException;
import javax.security.auth.Subject;

public class java_01296_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws AuthException, AccessControlException {
        // Unmarshalling password credential
        UnmarshalledPasswordCredential unmarshalledCredential = (UnmarshalledPasswordCredential) credential;

        // Check if the password is correct
        if ("password".equals(unmarshalledCredential.getPassword())) {
            return unmarshalledCredential;
        } else {
            throw new LoginException("Invalid password");
        }
    }
}