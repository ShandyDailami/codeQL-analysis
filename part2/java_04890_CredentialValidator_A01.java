import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_04890_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    public java_04890_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String providedUsername = usernamePasswordCredential.getIdentifier();
            String providedPassword = new String(usernamePasswordCredential.getPassword());

            if (providedUsername.equals(this.username) && providedPassword.equals(this.password)) {
                return CredentialValidatorResult.validResult();
            } else {
                return CredentialValidatorResult.invalidResult("Invalid username or password.");
            }
        } else {
            throw new CredentialException("Unsupported credential type: " + credential.getClass().getName());
        }
    }
}