import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;

import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.password.PasswordAuthenticationException;

public class java_11345_CredentialValidator_A07 {
    // The actual validation method
    public static boolean validate(String passwordAttempt, String password) throws NoSuchAlgorithmException, InvalidKeySpec {
        if (passwordAttempt.equals(password)) {
            return true;
        } else {
            throw new PasswordAuthenticationException("Authentication Failed: Password Incorrect");
        }
    }
}