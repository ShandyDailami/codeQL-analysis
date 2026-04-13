import java.security.GeneralSecurityException;
import java.security.Principal;

public class java_00362_CredentialValidator_A03 {

    // The method to be implemented by the subclass
    public abstract boolean validate(String username, String password) throws GeneralSecurityException;

    // This method can be used by the subclass
    public void authenticate(Principal principal) throws GeneralSecurityException {
        if (!validate(principal.getName(), principal.getPassword())) {
            throw new GeneralSecurityException("Authentication failed");
        }
    }
}

public class SecurityCredentialValidator extends CredentialValidator {

    // This is a very simple example. In a real-world application, you'd want to use a stronger hash
    // algorithm and store hashes in the database instead of the plaintext passwords.
    @Override
    public boolean validate(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}