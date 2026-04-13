import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_18731_CredentialValidator_A08 {

    private static final String SECRET = "super-secret-key";
    private static final String SALT = "salt-for-password-encryption";

    public static boolean isValid(String enteredPassword, String storedPassword) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] storedKeyBytes = Base64.getDecoder().decode(storedPassword);

            SecretKey originalKey = factory.getKey(storedKeyBytes);
            SecretKey newKey = factory.generateSecret(originalKey.getAlgorithm().getPbeParameters());

            PBEKeySpec pbeKeySpec = (PBEKeySpec) newKey.getAlgorithmParameters().getInstance("PBEKeySpec");
            pbeKeySpec.setPasswordPrefix(SECRET);

            SecretKey restoredKey = factory.generateSecret(pbeKeySpec);

            return newKey.equals(restoredKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            throw new IllegalStateException(e);
        }
    }

    public static String hashPassword(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] salt = SALT.getBytes();
            int iterations = 1000;
            int keyLength = 256;

            SecretKey originalKey = factory.getKey(password.getBytes());
            SecretKey restoredKey = factory.generateSecret(originalKey.getAlgorithm().getPbeParameters());

            return Base64.getEncoder().encodeToString(restoredKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        String password = "password123";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = isValid(password, hashedPassword);
        System.out.println("Is valid: " + isValid);
    }
}