import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_15425_CredentialValidator_A07 {

    private static final String SALT = "salt";
    private static final String DIGEST_ALGORITHM = "SHA-256";

    private String password;
    private String encryptedPassword;

    public java_15425_CredentialValidator_A07(String password) {
        this.password = password;
        encryptPassword();
    }

    private void encryptPassword() {
        try {
            MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM);
            byte[] hash = md.digest(password.getBytes());
            encryptedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No Such Algorithm: " + DIGEST_ALGORITHM, e);
        }
    }

    public boolean isPasswordValid() {
        if (Arrays.equals(decryptPassword(encryptedPassword), decryptPassword(password))) {
            return true;
        } else {
            return false;
        }
    }

    private byte[] decryptPassword(String encryptedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        return decodedBytes;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.isPasswordValid());
    }
}