import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_13737_CredentialValidator_A07 {

    // Credential store for authentication
    private String[] credentials = { "user1", "user2", "user3" };

    // Authenticate method
    public boolean authenticate(String user, String password) {
        for (String credential : credentials) {
            if (credential.equals(user) && credential.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Credential Validator
    public boolean validate(String caller, String password) throws CredentialNotFoundException, InvalidCredentialException, LoginException {
        if (authenticate(caller, password)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}