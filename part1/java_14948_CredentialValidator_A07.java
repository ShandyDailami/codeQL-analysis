import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;

public class java_14948_CredentialValidator_A07 {
    public boolean validate(X509Certificate certificate) {
        // This is a mock validation process. In a real scenario, the validation process
        // would involve more complex logic to ensure the credential is valid and has not expired.
        // Also, the validation process should ideally involve the actual credentials and not just the certificates.
        throw new UnsupportedOperationException();
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        
        // Here, for the purpose of this example, we're just validating the password.
        // In a real scenario, you'd want to hash the password and compare it to the hashed version stored in the database.
        if (password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long");
        }
        
        return true;
    }
}