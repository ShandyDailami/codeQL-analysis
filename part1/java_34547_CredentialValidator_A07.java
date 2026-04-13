import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.Key;

public class java_34547_CredentialValidator_A07 {

    private static final String SECRET = "super-secret-key";
    private static final String SALT = "salt";

    public boolean validate(String username, String password) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            Key key = skf.generateSecret(new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 5000, 256));
            byte[] bytes = key.getEncoded();
            SecretKey secretKey = new javax.crypto.spec.SecretKeySpec(bytes, 0, bytes.length);
            String hashedPassword = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            return hashedPassword.equals(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validate("username", "hashedPassword");
        System.out.println(valid); // print true or false
    }
}