import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_00939_CredentialValidator_A07 implements CredentialValidator {

    private static final String USER_DATA_STORE = "userDataStore";

    @Override
    public CredentialValidationResult validate(Credential credential) throws InvalidCredentialException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

            String username = usernamePasswordCredential.getCaller();
            String password = new String(usernamePasswordCredential.getPassword());

            // Check if the username and password are valid
            if ("testUser".equals(username) && "testPassword".equals(password)) {
                return new CredentialValidationResult("Success", USER_DATA_STORE, null);
            } else {
                throw new InvalidCredentialException("Invalid username or password");
            }
        } else {
            throw new InvalidCredentialException("Invalid credential type: " + credential.getClass().getName());
        }
    }
}