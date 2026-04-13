import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_09329_CredentialValidator_A07 {
    private static final String AES = "AES";
    private static final String KEY = "12345678abcdefgh"; // 128 bit key
    private static final String INIT_VECTOR = "12345678abcdefgh"; // 128 bit IV

    private java_09329_CredentialValidator_A07() {
        throw new UnsupportedOperationException();
    }

    public static SecretKey generateKey() throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128); // AES requires a 128 bit key
        return keyGenerator.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws GeneralSecurityException {
        byte[] encryptedData = encrypt(data.getBytes(), key);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String data, SecretKey key) throws GeneralSecurityException {
        byte[] encryptedData = Base64.getDecoder().decode(data);
        byte[] decryptedData = decrypt(encryptedData, key);
        return new String(decryptedData);
    }

    public static byte[] encrypt(byte[] data, SecretKey key) throws GeneralSecurityException {
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, SecretKey key) throws GeneralSecurityException {
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    public static boolean validate(String username, String password, SecretKey key) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        try {
            byte[] encryptedPassword = encrypt(password, key);
            // Assume there is a method in your system to fetch encrypted password for a given username
            String storedPassword = getPassword(username);
            // Compare the encrypted passwords
            return storedPassword.equals(encryptedPassword);
        } catch (GeneralSecurityException e) {
            throw new InvalidParameterException("Invalid key");
        }
    }

    private static String getPassword(String username) {
        // Implementation of a method to retrieve the encrypted password for a given username
        // This would depend on how your system is structured
        return "encryptedPassword";
    }
}