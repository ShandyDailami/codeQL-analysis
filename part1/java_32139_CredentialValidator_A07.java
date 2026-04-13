import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import java.sql.SQLException;
import java.util.Base64;

public class java_32139_CredentialValidator_A07 implements CredentialValidator {
    @Override
    public boolean validate(java.security.credential.Credential credential) throws CredentialInvalidException {
        String username = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));
        String password = new String(credential.getCredential());

        try {
            // Implement your security-sensitive operations here
            // For example, validate against a database
            if (username.equals("admin") && password.equals("password")) {
                return true;
            } else {
                throw new CredentialInvalidException("Invalid username or password");
            }
        } catch (SQLException e) {
            throw new CredentialInvalidException(e);
        }
    }
}