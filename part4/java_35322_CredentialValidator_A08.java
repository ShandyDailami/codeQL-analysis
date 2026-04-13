import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class java_35322_CredentialValidator_A08 {

    private static final String SECRET = "super-secret-key"; // Replace with your actual secret
    private static final String SALT = "super-salt"; // Replace with your actual salt

    public boolean validate(String password) throws NoSuchAlgorithmException {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            SecretKey s = skf.generateSecret(new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 512, 512));
            byte[] actual = s.getEncoded();
            byte[] generated = password.getBytes();
            return Base64.getEncoder().encodeToString(actual).equals(Base64.getEncoder().encodeToString(generated));
        } catch (InvalidKeySpec e) {
            throw new AssertionError("Invalid key spec", e);
        }
    }
}