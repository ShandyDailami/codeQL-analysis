import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.PasswordAuthenticationException;

public class java_03188_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public String getCallerPrincipal() {
        return "Admin";
    }

    @Override
    public String getUniqueIdentifier() {
        return "Admin";
    }

    @Override
    public boolean validate(javax.security.auth.credential.Credential credential)
            throws PasswordAuthenticationException {
        String password = credential.getPassword();
        
        if (password.equals("password")) {
            return true;
        } else {
            throw new PasswordAuthenticationException("Invalid password");
        }
    }
}