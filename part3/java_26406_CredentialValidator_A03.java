import java.security.InvalidParameterException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_26406_CredentialValidator_A03 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/CBC/PKCS5Padding";

    private SecretKey decodedKey;
    private IvParameterSpec ivParameterSpec;

    public java_26406_CredentialValidator_A03(String key) {
        this.decodedKey = decodeKey(key);
        this.ivParameterSpec = new IvParameterSpec(decodedKey.getEncoded());
    }

    public boolean validate(String passwordAttempt) throws InvalidAlgorithmParameterException {
        if (passwordAttempt.length() != 16) {
            throw new InvalidParameterException("Password must be 16 characters long");
        }

        byte[] encryptedPassword = Base64.getDecoder().decode(passwordAttempt);

        try {
            SecretKey key = getSecretKey();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

            byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

            return comparePasswords(passwordAttempt, new String(decryptedPassword));
        } catch (Exception e) {
            throw new InvalidAlgorithmParameterException("Error while decrypting password", e);
        }
    }

    private SecretKey getSecretKey() throws InvalidAlgorithmParameterException {
        KeySpec keySpec = new SecretKeySpec(decodedKey.getEncoded(), "AES");
        return SecretKeyFactory.getInstance("AES").generateSecret(keySpec);
    }

    private boolean comparePasswords(String passwordAttempt, String decryptedPassword) {
        return passwordAttempt.equals(decryptedPassword);
    }

    private SecretKey decodeKey(String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
}