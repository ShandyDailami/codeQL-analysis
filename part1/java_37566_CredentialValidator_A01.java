// Import necessary libraries
import javax.naming.AuthenticationException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public interface CredentialValidator {
    void validate(UsernamePasswordCredentials credentials) throws LoginException, AuthenticationException, CredentialNotFoundException;
}

// UsernamePasswordCredentials class java_37566_CredentialValidator_A01 class UsernamePasswordCredentials {
    private String username;
    private char[] password;

    public SimpleCredentialValidator(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters
}

// CredentialValidator implementation
public class SimpleCredentialValidator implements CredentialValidator {
    private final char[][] credentials = {
        { 'u', 's', 'e', 'r' },
        { 'p', 'a', 's', 's' },
        { 'w', 'o', 'r', 'l' },
        { 'd', 'e', 'm', 'o' }
    };

    public void validate(UsernamePasswordCredentials credentials) throws LoginException, AuthenticationException, CredentialNotFoundException {
        if (credentials.getUsername().equals("demo")) {
            if (Arrays.equals(credentials.getPassword(), credentials.getUsername().toCharArray())) {
                throw new CredentialNotFoundException("Wrong password");
            }
            throw new AuthenticationException("Incorrect username");
        }
        throw new LoginException("Incorrect username");
    }
}