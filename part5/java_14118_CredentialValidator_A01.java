import java.security.cert.X509Certificate;
import java.util.regex.Pattern;

public class java_14118_CredentialValidator_A01 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public boolean validateUsername(String username) {
        return !username.trim().isEmpty();
    }

    public boolean validatePassword(String password) {
        return !password.trim().isEmpty();
    }

    public boolean validateCertificate(X509Certificate certificate) {
        return certificate != null;
    }

    public boolean validate(String email, String username, String password, X509Certificate certificate) {
        return validateEmail(email)
                && validateUsername(username)
                && validatePassword(password)
                && validateCertificate(certificate);
    }
}