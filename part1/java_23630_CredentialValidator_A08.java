import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_23630_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws LoginException {
        // Check password against a hardcoded string
        return arg0.getCredential().equals("password");
    }

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }
}