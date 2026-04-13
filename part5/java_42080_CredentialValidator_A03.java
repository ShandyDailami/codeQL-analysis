import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encodings.Base64;

public class java_42080_CredentialValidator_A03 {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private static final int KEY_SIZE = 256;

    public static byte[] createHashedPassword(String password) throws NoSuchAlgorithmException {
        SHA256Digest digest = new SHA256Digest();
        byte[] passwordBytes = password.getBytes();
        digest.update(passwordBytes, 0, passwordBytes.length);
        byte[] hashedPassword = new byte[digest.getDigestSize()];
        digest.doFinal(hashedPassword, 0);
        return hashedPassword;
    }

    public static byte[] createRandomIV(int size) {
        byte[] iv = new byte[size];
        secureRandom.nextBytes(iv);
        return iv;
    }

    public static byte[] createHMAC(String password, byte[] hashedPassword, byte[] iv) throws NoSuchAlgorithmException, InvalidKeyException, InvalidParameterSpecException {
        byte[] passwordBytes = password.getBytes();
        Key secretKey = new SecretKeySpec(hashedPassword, HMAC_SHA256_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(new javax.crypto.spec.SecretKeySpec(secretKey.getEncoded(), HMAC_SHA256_ALGORITHM));
        mac.update(iv, 0, iv.length);
        byte[] hmac = new byte[mac.getMacSize()];
        mac.doFinal(hmac, 0);
        return hmac;
    }

    public static boolean isPasswordValid(String password, byte[] hashedPassword, byte[] iv, byte[] storedHMAC) throws NoSuchAlgorithmException, InvalidKeyException, InvalidParameterSpecException {
        byte[] calculatedHMAC = createHMAC(password, hashedPassword, iv);
        return Arrays.equals(storedHMAC, calculatedHMAC);
    }
}