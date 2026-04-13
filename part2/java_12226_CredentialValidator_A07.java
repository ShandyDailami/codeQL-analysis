import javax.security.auth.credential.*;
import javax.security.auth.*;

public class java_12226_CredentialValidator_A07 implements CredentialValidator {

    // Define a set of predefined rules
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]{8,}$";

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {

        // Retrieve credentials
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        String username = usernamePasswordCredential.getCaller();
        char[] password = usernamePasswordCredential.getPassword();

        // Validate username and password
        if (!username.matches(USERNAME_REGEX) || !new String(password).matches(PASSWORD_REGEX)) {
            throw new AuthenticationException("Invalid username or password.");
        }

        return true;
    }
}