import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_41436_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private static final long serialVersionUID = 1L;

    @Override
    public Subject validate(Credential credential) throws CredentialException, LoginException {

        String userName = null;
        String password = null;

        // Convert Credential to UsernamePasswordCredential
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            userName = usernamePasswordCredential.getUserName();
            password = new String(usernamePasswordCredential.getPassword());
        } else {
            throw new CredentialException("This CredentialValidator only supports UsernamePasswordCredential");
        }

        // Add your security-sensitive operations here
        // For example, check if the user is in a known bad word list
        if (isBadWord(userName)) {
            throw new LoginException("Bad word found in username");
        }
        if (isBadWord(password)) {
            throw new LoginException("Bad word found in password");
        }

        return null; // Return null if the user is authenticated
    }

    private boolean isBadWord(String word) {
        // Implement your own logic for checking if a word is bad word
        // For now, let's just return true for demonstration
        return true;
    }
}