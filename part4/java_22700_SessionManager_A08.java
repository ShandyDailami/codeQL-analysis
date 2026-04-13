import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_22700_SessionManager_A08 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_ECB";
    private static final byte[] keyValue = "A08_IntegrityFailure".getBytes();

    private SecretKey getKey() throws Exception {
        Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();
        return new SecretKeySpec(key, 0, key.getKeySize(), ALGORITHM, "AES");
    }

    private byte[] encrypt(byte[] plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plainText);
    }

    private byte[] decrypt(byte[] encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedText);
    }

    public static void main(String[] args) throws Exception {
        SessionManager sm = new SessionManager();
        SecretKey key = sm.getKey();
        byte[] encryptedText = sm.encrypt("Hello, World!", key);
        byte[] decryptedText = sm.decrypt(encryptedText, key);

        System.out.println(new String(decryptedText));
    }
}