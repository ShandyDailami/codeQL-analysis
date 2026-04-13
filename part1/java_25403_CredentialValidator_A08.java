import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

import java.util.regex.Pattern;

public class java_25403_CredentialValidator_A08 {

    // The pattern for validating email addresses
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // The pattern for validating phone numbers
    private static final Pattern VALID_PHONE_REGEX =
        Pattern.compile("^(?:(?=.*[0-9])(?:.*[a-z])(?:.*[A-Z])|(?:.*[a-z])(?:.*[A-Z])|(?:.*[A-Z]))[0-9a-zA-Z.-]{9,}$", Pattern.CASE_INSENSITIVE);

    // The pattern for validating passwords
    private static final Pattern VALID_PASSWORD_REGEX =
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String email) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public boolean validatePhone(String phone) {
        return VALID_PHONE_REGEX.matcher(phone).matches();
    }

    public boolean validatePassword(String password) {
        return VALID_PASSWORD_REGEX.matcher(password).matches();
    }

    // A sample of how to use the class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateEmail("test@example.com"));  // Returns true
        System.out.println(validator.validatePhone("+1-800-123-4567"));  // Returns true
        System.out.println(validator.validatePassword("Password@123"));  // Returns true
    }
}