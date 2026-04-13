import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_09764_CredentialValidator_A01 {

    private byte[] knownPassword;
    private MessageDigest digest;

    public java_09764_CredentialValidator_A01(String password) {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
            this.knownPassword = digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // handle exception
        }
    }

    public boolean validate(String passwordAttempt) {
        byte[] attemptedPasswordDigest;
        try {
            attemptedPasswordDigest = digest.digest(passwordAttempt.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // handle exception
            return false;
        }

        if (Arrays.equals(attemptedPasswordDigest, knownPassword)) {
            return true;
        } else {
            return false;
        }
    }
}