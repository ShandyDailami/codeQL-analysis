import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.Destroyable;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_22403_CredentialValidator_A03 implements CredentialValidator, Destroyable {

    // Hard-coded password to validate against
    private String password;

    public java_22403_CredentialValidator_A03() {
        // Hard-coded password to validate against
        this.password = "secret";
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws InvalidCredentialException {
        String password = c.getPassword();
        if (password != null && password.equals(this.password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            throw new InvalidCredentialException("Authentication failed");
        }
    }

    @Override
    public void destroy() throws DestroyableContextException {
        // No cleanup needed here
    }
}