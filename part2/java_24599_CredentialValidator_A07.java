import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class java_24599_CredentialValidator_A07 {

    private static final String SECRET = "56e98658-4ec9-4e98-9f8e-5a90f6bedcd1"; // This should be a secret key that is known only to the system and not to the user
    private static final String SALT = "5ac98652-4ec9-4998-9f8e-5a90f6bedcd3"; // This should also be a secret key that is known only to the system and not to the user

    public boolean validate(String enteredPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey key = factory.generateSecret(new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 5000, 512));

        byte[] providedPasswordBytes = enteredPassword.getBytes();
        byte[] storedPasswordBytes = storedPassword.getBytes();

        return Base64.getEncoder().encodeToString(key.getEncoded()).equals(Base64.getEncoder().encodeToString(providedPasswordBytes));
    }
}