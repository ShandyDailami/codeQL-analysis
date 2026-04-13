import java.util.Arrays;
import java.util.List;
import java.util.Base64;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_11767_CredentialValidator_A03 {

    // List of authorized users
    private static final List<String> AUTHORIZED_USERS = Arrays.asList("user1", "user2", "user3");

    // Method to validate the credentials
    public boolean validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String user = new String(Base64.getDecoder().decode(usernamePasswordCredential.getCaller()));
            String password = new String(Base64.getDecoder().decode(usernamePasswordCredential.getPassword()));

            // Validate the credentials against the list of authorized users
            if (AUTHORIZED_USERS.contains(user) && password.equals("password")) {
                return true;
            }
        }

        // If the credentials are not valid, throw a FailedLoginException
        throw new FailedLoginException("Invalid username or password");
    }
}