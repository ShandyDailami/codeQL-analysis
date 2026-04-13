import java.security.Credential;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;

public class java_13995_CredentialValidator_A03 {
    private static final String ALGORITHM = "SHA-256";

    private java_13995_CredentialValidator_A03() {
        // Prevent instantiation
    }

    public static boolean validate(String passwordAttempt, Credential credential) {
        try {
            if (credential == null) {
                throw new InvalidParameterException("Credential cannot be null");
            }

            byte[] passwordAttemptBytes = passwordAttempt.getBytes();
            byte[] storedPasswordBytes = credential.getPassword();

            if (passwordAttemptBytes.length != storedPasswordBytes.length) {
                throw new InvalidParameterException("Password lengths must match");
            }

            for (int i = 0; i < passwordAttemptBytes.length; i++) {
                if (passwordAttemptBytes[i] != storedPasswordBytes[i]) {
                    return false;
                }
            }

            return true;
        } catch (NoSuchAlgorithmException | GeneralSecurityException e) {
            e.printStackTrace(); // You can use a logging system here
            return false;
        }
    }
}