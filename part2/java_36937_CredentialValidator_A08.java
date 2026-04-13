import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_36937_CredentialValidator_A08 {

    // Array of known usernames and passwords
    private static final String[][] knownUsers = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
    };

    public boolean validate(Credential credential) {
        // Check if credential is null
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }

        // Check if credential is a UsernamePasswordCredential
        if (!(credential instanceof UsernamePasswordCredential)) {
            throw new IllegalArgumentException("Credential must be a UsernamePasswordCredential");
        }

        // Cast credential to UsernamePasswordCredential
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

        // Get username and password from credential
        String username = usernamePasswordCredential.getCaller();
        char[] password = usernamePasswordCredential.getPassword();

        // Check if username and password is null or empty
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null or empty");
        }

        // Check if username and password matches a known username and password
        for (String[] user : knownUsers) {
            if (username.equals(user[0]) && passwordToString(password).equals(user[1])) {
                return true;
            }
        }

        return false;
    }

    private String passwordToString(char[] password) {
        // Convert char array to String for comparison
        return new String(password);
    }
}