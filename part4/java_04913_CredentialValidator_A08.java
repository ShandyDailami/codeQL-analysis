import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class java_04913_CredentialValidator_A08 {

    // Shared secret key used for HMAC
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    // Encryption key
    private static final String ENCRYPTION_KEY = "encryptionKey";

    // Validate HMAC
    public boolean validateHMAC(byte[] message, byte[] expected, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(new SecretKeySpec(ENCRYPTION_KEY.getBytes(), HMAC_SHA1_ALGORITHM));
        byte[] actual = mac.doFinal(message);
        return MessageDigest.isEqual(expected, actual);
    }

    // Validate integrity
    public boolean validateIntegrity(byte[] message, byte[] expected) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(new SecretKeySpec(ENCRYPTION_KEY.getBytes(), HMAC_SHA1_ALGORITHM));
        byte[] actual = mac.doFinal(message);
        return MessageDigest.isEqual(expected, actual);
    }

    // Validate encryption
    public boolean validateEncryption(byte[] message, byte[] expected, Key key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(new SecretKeySpec(ENCRYPTION_KEY.getBytes(), HMAC_SHA1_ALGORITHM));
        byte[] actual = mac.doFinal(message);
        return MessageDigest.isEqual(expected, actual);
    }
}