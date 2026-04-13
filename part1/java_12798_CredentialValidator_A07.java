import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_12798_CredentialValidator_A07 {

    private static final String SECRET = "secret"; // This should be your secret key
    private static final String SALT = "salt"; // This should be a unique string for each user

    public boolean validate(String username, String password) {
        try {
            SecretKey secret = getSecretKeyFromPassword(password);
            return secret.equals(getSecretKeyFromPassword(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private SecretKey getSecretKeyFromPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpec {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), 10000, 512);
        SecretKey secret = factory.generateSecret(spec);
        return secret;
    }

}