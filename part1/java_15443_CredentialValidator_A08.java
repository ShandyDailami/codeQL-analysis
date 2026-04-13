import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import java.security.InvalidParameterException;

public class java_15443_CredentialValidator_A08 {
    private String storedPassword;

    public java_15443_CredentialValidator_A08(String password) {
        this.storedPassword = password;
    }

    public boolean validate(Credential credential) throws CredentialException, PasswordChangeException {
        if (credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }
        String providedPassword = credential.getPassword();
        if (providedPassword == null) {
            throw new CredentialException("Provided password is null");
        }
        return verifyPassword(providedPassword);
    }

    private boolean verifyPassword(String password) throws PasswordChangeException {
        // This is a placeholder for actual password verification.
        // In real scenario, we should use some kind of hashing and compare the hash of input password with the stored one.
        // We also should not store the hashed password, we should use it only for verification.
        return password.equals(this.storedPassword);
    }
}