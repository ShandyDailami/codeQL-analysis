import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.Base64;

public class java_22001_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(java.util.Collection<java.security.auth.Credential> credentials) throws CredentialException, InvalidCredentialException {
        for (java.security.auth.Credential credential : credentials) {
            String username = credential.getIdentifier();
            String password = new String(credential.getCredentialIdentifier(), "UTF-8");

            // Hard-coded credentials
            String hardcodedUsername = "admin";
            String hardcodedPassword = "password";

            // Decoding password to Base64
            byte[] decodedPassword = Base64.getDecoder().decode(password);

            if (hardcodedUsername.equals(username) && hardcodedPassword.equals(new String(decodedPassword, "UTF-8"))) {
                return true;
            }
        }
        return false;
    }
}