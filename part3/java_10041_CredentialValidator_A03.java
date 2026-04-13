import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_10041_CredentialValidator_A03 implements CredentialValidator {

    private static final String ALGORITHM = "MD5";

    @Override
    public boolean validate(String username, String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 not available. " +
                    "Please adjust your Java edition.");
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String securePassword = Base64.getEncoder().encodeToString(digest);
        return Arrays.equals(this.getPasswordHash(username), securePassword.getBytes());
    }

    private byte[] getPasswordHash(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 not available. " +
                    "Please adjust your Java edition.");
        }
        md.update(password.getBytes());
        return md.digest();
    }
}