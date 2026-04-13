import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_36390_CredentialValidator_A08 {

    private static final Pattern VALID_DOMAIN_PATTERN = Pattern.compile("^[a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])$");
    private static final Pattern VALID_EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@"
            + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])"
            + "(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    public boolean validateDomain(String domain) {
        Matcher matcher = VALID_DOMAIN_PATTERN.matcher(domain);
        return matcher.matches();
    }

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public boolean validateCertificate(X509Certificate certificate) {
        // Here you can add logic to validate the certificate against security rules.
        // For example, you can check if the certificate has expired, if it has a valid signature algorithm, etc.
        return true;
    }

}