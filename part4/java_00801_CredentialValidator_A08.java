import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_00801_CredentialValidator_A08 {

    private Credential credential;

    public java_00801_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public String validate(String username, String password) throws CredentialException, InvalidCredentialException, CredentialNotFoundException {
        if (!credential.isValid(username, password)) {
            throw new InvalidCredentialException("Invalid username or password");
        }
        return "Validated successfully";
    }
}