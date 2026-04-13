import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.text.View;

public class java_02911_CredentialValidator_A08 {

    private SecretKey secretKey;

    public java_02911_CredentialValidator_A08(String secretKey) throws NoSuchAlgorithmException {
        this.secretKey = toSecretKey(secretKey);
    }

    public boolean isPasswordValid(String password, String encodedPassword) {
        try {
            String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));
            return this.secretKey.equals(toSecretKey(password));
        } catch (Exception e) {
            return false;
        }
    }

    private SecretKey toSecretKey(String password) throws NoSuchAlgorithmException {
        byte[] hashedPassword = hash(password);
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                .generateSecret(new PBEKeySpec(password.toCharArray(), hashedPassword, 1000, 256));
    }

    private byte[] hash(String password) throws NoSuchAlgorithmException {
        return SecretUtils.hash(password, SecretUtils.HASH_ALGORITHM.SHA256);
    }

    public static class SecretUtils {
        public enum HASH_ALGORITHM {
            SHA1, SHA256, SHA384, SHA512
        }

        public static byte[] hash(String input, HASH_ALGORITHM algorithm) throws NoSuchAlgorithmException {
            return hash(input, algorithm, 1000);
        }

        public static byte[] hash(String input, HASH_ALGORITHM algorithm, int iterations) throws NoSuchAlgorithmException {
            byte[] salt = "salt".getBytes();
            return hash(new String(salt), input, algorithm, iterations);
        }

        public static byte[] hash(byte[] salt, String input, HASH_ALGORITHM algorithm, int iterations) throws NoSuchAlgorithmException {
            byte[] password = input.getBytes();
            byte[] saltedPassword = new byte[salt.length + password.length];
            System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
            System.arraycopy(password, 0, saltedPassword, salt.length, password.length);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(new PBEKeySpec(saltedPassword, salt, iterations, 256))
                    .getEncoded();
        }
    }
}