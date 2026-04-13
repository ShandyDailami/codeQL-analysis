import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.login.PasswordAuthentication;

public class java_41587_CredentialValidator_A01 {
    public CredentialValidationResult validate(PasswordAuthentication passwordAuthentication) throws LoginException {
        String password = passwordAuthentication.getPasswordAsString();
        boolean isStrong = isPasswordStrong(password);

        if (isStrong) {
            return new CredentialValidationResult("Successful authentication", null);
        } else {
            return new CredentialValidationResult("Weak password, please use a stronger one", null);
        }
    }

    private boolean isPasswordStrong(String password) {
        // Define your own password strength check logic here.
        // This is a very basic example and might not work for all passwords.
        // In a real application, you would probably want to use a library or framework for password strength checks.
        return password.length() >= 8;
    }
}