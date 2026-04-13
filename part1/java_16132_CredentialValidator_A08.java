import java.security.PublicKey;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class java_16132_CredentialValidator_A08 {
    // A very simple password strength check
    public static boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        // Minimum eight characters, one uppercase, one lowercase, one number and one special character
        // TODO: Add more complex password validation rules
        return (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])"));
    }
}