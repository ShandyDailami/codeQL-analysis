import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.SecurityConfig;
import javax.security.auth.validation.SecurityToken;

public class java_16953_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(SecurityToken arg0) {
        boolean valid = false;
        String username = arg0.getIdentifier();
        String password = (String) arg0.getCredentialIdentifiers()[0];

        if (username.equals("test") && password.equals("test")) {
            valid = true;
        }
        return valid;
    }

    @Override
    public boolean getRequestedUsernameTokenPattern() {
        return false;
    }

    @Override
    public SecurityConfig getSecurityConfig() {
        return null;
    }

    @Override
    public void initialize(String arg0, SecurityContext arg1) throws LoginException {
        // TODO Auto-generated method stub
        
    }

}