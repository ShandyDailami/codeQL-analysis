import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class java_09528_CredentialValidator_A08 {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int iterations = 1000;
    private static final int keyLength = 256;

    public boolean validate(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String key = "your_key"; // This should be stored in a secure manner
        byte[] keyBytes = key.getBytes();

        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey keyFromKeyBytes = new SecretKeySpec(keyBytes, 0, keyBytes.length, skf.getAlgorithm());

        // Create a PBKDF2 key from the key bytes and the salt
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), keyFromKeyBytes.getEncoded(), iterations, keyLength);
        SecretKey keyGenerated = skf.generateSecret(spec);

        byte[] providedBytes = keyFromKeyBytes.getEncoded();

        // Check that the two keys are equal
        return (Pattern.matches("^" + keyGenerated.getEncoded() + "$", providedBytes));
    }
}