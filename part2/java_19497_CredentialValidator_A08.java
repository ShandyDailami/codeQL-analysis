import java.util.Optional;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_19497_CredentialValidator_A08 {

    private static final String algorithm = "AES";
    private static final String password = "password";
    private static final String salt = "salt";
    private static final String iv = "iv";

    public static Optional<String> validate(String input) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key = skf.createKey(password.getBytes());
            SecretKeySpec secretKey = new SecretKeySpec(key.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return Optional.of(new String(decryptedBytes));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}