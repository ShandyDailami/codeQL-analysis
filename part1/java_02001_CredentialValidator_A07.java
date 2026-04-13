import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_02001_CredentialValidator_A07 {
    private static final String SALT_GEN_ALGORITHM = "SHA1PRNG";
    private static final int SALT_SIZE = 16;
    private static final int KEY_SIZE = 256;
    private static final int ITERATIONS = 65536;
    private static final String KEY_ALGORITHM = "PBKDF2WithHmacSHA1";

    private SecretKeyFactory skf;

    public java_02001_CredentialValidator_A07() throws GeneralSecurityException {
        this.skf = SecretKeyFactory.getInstance(KEY_ALGORITHM);
    }

    private SecretKey getKeyFromPassword(String password, byte[] salt) throws GeneralSecurityException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_SIZE);
        return skf.generateSecret(spec);
    }

    private byte[] getSalt() throws GeneralSecurityException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        sr.nextBytes(salt);
        return salt;
    }

    public String hashPassword(String password) throws GeneralSecurityException {
        byte[] salt = getSalt();
        SecretKey key = getKeyFromPassword(password, salt);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public boolean validatePassword(String password, String hash) throws GeneralSecurityException, InvalidKeyException {
        String[] split = hash.split(":");
        if (split.length != 2) {
            throw new InvalidParameterSpecException("Invalid hash size");
        }

        byte[] salt = Base64.getDecoder().decode(split[0]);
        SecretKey key = getKeyFromPassword(password, salt);
        return key.equals(getKeyFromPassword(password, Base64.getDecoder().decode(split[1])));
    }
}