import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import java.security.AccessControlException;

public class java_16249_CredentialValidator_A01 implements javax.security.auth.credential.PasswordValidator {

    @Override
    public boolean validate(Credential c) throws CredentialException, AccessControlException {
        String password = c.getCredential();
        return password.length() > 8;
    }
}