import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class java_20548_CredentialValidator_A01 {
    private static final String SECRET = "mySecret";
    private static final String SALT = "mySalt";

    public static boolean validate(String password) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            SecretKey secret = secretKeyFactory.createKey(SECRET.getBytes());

            byte[] hash = secret.getEncoded();
            byte[] test = secretKeyFactory.deriveKey(SALT.getBytes()).getEncoded();
            return secretKeyFactory.verify(hash, test);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("correct_password")); // True
        System.out.println(validate("wrong_password")); // False
    }
}