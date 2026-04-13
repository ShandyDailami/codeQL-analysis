import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_14541_CredentialValidator_A01 {

    private final String hardcodedUsername;
    private final SecretKey hardcodedPassword;

    public java_14541_CredentialValidator_A01(String hardcodedUsername, String hardcodedPassword) throws NoSuchAlgorithmException {
        this.hardcodedUsername = hardcodedUsername;
        this.hardcodedPassword = generatePasswordHash(hardcodedPassword);
    }

    private SecretKey generatePasswordHash(String password) throws NoSuchAlgorithmException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] encodedKey = factory.generateKey(new String(password).getBytes()).getBytes();
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateKey(encodedKey);
    }

    public boolean isValidCredentials(String providedUsername, String providedPassword) throws NoSuchAlgorithmException, InvalidKeySpec {
        if(!this.hardcodedUsername.equals(providedUsername)) {
            return false;
        }

        SecretKey factoryKey = this.hardcodedPassword;

        PBEKeySpec spec = new PBEKeySpec(providedPassword.toCharArray(), this.hardcodedPassword.getBytes(), 10000, 256);
        SecretKey key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec);

        byte[] dbKey = factoryKey.getEncoded();

        return Base64.getEncoder().encodeToString(key.getEncoded()).equals(Base64.getEncoder().encodeToString(dbKey));
    }
}