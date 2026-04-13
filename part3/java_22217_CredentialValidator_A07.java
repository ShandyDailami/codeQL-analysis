import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.UsernamePasswordCredential;

public class java_22217_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_22217_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        // Validate the provided credentials
        if (credential.getUsername().equals(this.username) &&
            credential.getPassword().equals(this.password)) {
            return null; // Credentials are valid
        } else {
            throw new PasswordChangeException("Invalid username or password."); // Credentials are not valid
        }
    }
}