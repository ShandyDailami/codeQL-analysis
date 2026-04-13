import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_06606_CredentialValidator_A03 {

    private static final String SECRET = "my-secret-key";
    private static final String SALT = "my-salt";

    public boolean isValid(String password) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey secret = secretKeyFactory.create(getSaltAndPasswordAsBytes());
            byte[] digest = secret.getEncoded();

            byte[] checkDigest = secretKeyFactory.create(getSaltAndPasswordAsBytes()).getEncoded();

            return Arrays.equals(digest, checkDigest);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
            return false;
        }
    }

    private byte[] getSaltAndPasswordAsBytes() {
        return Base64.getDecoder().decode(SALT + "&" + SECRET);
    }
}