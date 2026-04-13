import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;

public class java_32134_CredentialValidator_A08 {
    private Credential credential;

    public java_32134_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public boolean isValid(String username, String password) {
        // Hash the password using a secure algorithm
        String hashedPassword = "";
        try {
            hashedPassword = PasswordUtils.hashPassword(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
        }

        // Verify the hashed password with the stored password
        return credential.verifyPassword(hashedPassword);
    }
}