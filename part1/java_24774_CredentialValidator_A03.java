import javax.security.auth.Subject;
import java.security.cert.X509Certificate;

public class java_24774_CredentialValidator_A03 {

    public boolean authenticate(Subject subject, String password) {
        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check for lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for numbers
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}