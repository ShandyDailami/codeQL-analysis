import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_16128_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public String validate(Subject subject, Object credentials) throws LoginException, InvalidCredentialException {
        String password = (String) credentials;
        
        if (password.length() < 8) {
            throw new InvalidCredentialException("Password length must be at least 8 characters long");
        }
        
        return null;
    }
    
}