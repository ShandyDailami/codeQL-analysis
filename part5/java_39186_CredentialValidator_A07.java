import javax.security.auth.Credential;
import javax.security.auth.LoginException;
import javax.security.auth.UnavailableSecurityException;
import javax.security.auth.UsernamePasswordCredential;

public class java_39186_CredentialValidator_A07 {

    private static final String VALID_PASSWORD = "validPassword";

    public boolean validate(Credential credential) throws LoginException, UnavailableSecurityException {
        // UsernamePasswordCredential is used to get username and password
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        
        // Check if the password matches the hardcoded pattern
        if (usernamePasswordCredential.getPassword() != null && 
            usernamePasswordCredential.getPassword().equals(VALID_PASSWORD)) {
            return true;
        }
        return false;
    }

}